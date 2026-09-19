package ru.ksergey.StudyProjectWebStart.service;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ksergey.StudyProjectWebStart.dao.ContactOwnerRepository;
import ru.ksergey.StudyProjectWebStart.dao.ContactRepository;
import ru.ksergey.StudyProjectWebStart.exception.handler.customException.EntityNotFoundException;
import ru.ksergey.StudyProjectWebStart.exception.handler.customException.ValidationException;
import ru.ksergey.StudyProjectWebStart.model.dto.CreateContactDto;
import ru.ksergey.StudyProjectWebStart.model.dto.UpdateContactDto;
import ru.ksergey.StudyProjectWebStart.model.entity.Contact;
import ru.ksergey.StudyProjectWebStart.model.entity.ContactDetail;
import ru.ksergey.StudyProjectWebStart.model.entity.ContactOwner;

import java.util.List;

@Slf4j
@Service
public class ContactServiceImpl implements ContactService{
    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;
    private final ContactOwnerService contactOwnerService;


    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository,
                              ModelMapper modelMapper,
                              ContactOwnerService contactOwnerService) {
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
        this.contactOwnerService = contactOwnerService;
    }

    @Override
    public List<Contact> getAllContacts() {
        log.info("    >> HEY HEY");
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(int id) {
        return contactRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Контакт не найден"));
    }

    @Override
    public Contact createContact(CreateContactDto dto) {
        ContactOwner contactOwner = contactOwnerService.getContactOwnerById(dto.getOwnerId());


        contactRepository.findByEmail(dto.getEmail())
                .ifPresent(contact -> {
                    throw new ValidationException("Контакт с таким email уже существует");
                });
        Contact contact = modelMapper.map(dto,Contact.class);

        contact.setOwner(contactOwner);
        contactOwner.getContacts().add(contact);
        if (dto.getContactDetail()!= null){
            ContactDetail contactDetail = modelMapper.map(
                    dto.getContactDetail(),
                    ContactDetail.class
            );
            contactDetail.setContact(contact);
            contact.setContactDetail(contactDetail);
        }

        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(UpdateContactDto dto) {
        ContactOwner contactOwner = contactOwnerService.getContactOwnerById(dto.getOwnerId());


        Contact existingContact = contactRepository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Контакт не найден"));

        if (!existingContact.getOwner().getId().equalsIgnoreCase(dto.getOwnerId())){
            throw new ValidationException("У вас нет прав обновления этого контакта");
        }

        contactRepository.findByEmail(dto.getEmail())
                .ifPresent(contact -> {
                    if (contact.getId()!= dto.getId()){
                        throw new ValidationException("Контакт с таким email уже существует");
                    }
                });

        modelMapper.map(dto,existingContact);
        return contactRepository.save(existingContact);
    }

    @Override
    public boolean deleteContact(int id) {
        if (contactRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException("Контакт не найден");
        }
        return contactRepository.deleteById(id);
    }
}

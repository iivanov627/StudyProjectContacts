package ru.ksergey.StudyProjectWebStart.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ksergey.StudyProjectWebStart.dao.ContactOwnerRepository;
import ru.ksergey.StudyProjectWebStart.exception.handler.customException.EntityNotFoundException;
import ru.ksergey.StudyProjectWebStart.exception.handler.customException.ValidationException;
import ru.ksergey.StudyProjectWebStart.model.dto.CreateContactOwnerDto;
import ru.ksergey.StudyProjectWebStart.model.dto.UpdateContactOwnerDto;
import ru.ksergey.StudyProjectWebStart.model.entity.ContactOwner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ContactOwnerServiceImpl implements ContactOwnerService{

    private final ContactOwnerRepository contactOwnerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ContactOwnerServiceImpl(ContactOwnerRepository contactOwnerRepository,
                                   ModelMapper modelMapper) {
        this.contactOwnerRepository = contactOwnerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ContactOwner> getAllContactOwners() {
        return contactOwnerRepository.findAll();
    }

    @Override
    public ContactOwner getContactOwnerById(UUID id) {
        return contactOwnerRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Такой владелец контакта не существует"));
    }

    @Override
    public ContactOwner createContactOwner(CreateContactOwnerDto createDto) {
        contactOwnerRepository.findByEmail(createDto.getEmail())
                .ifPresent(co-> {
                throw new ValidationException("email занят");
                });

        contactOwnerRepository.findByUsername(createDto.getUsername())
                .stream()
                .findFirst()
                .ifPresent(co-> {
                    throw new ValidationException("username занят");
                });

        ContactOwner contactOwner = modelMapper.map(createDto, ContactOwner.class);
        return contactOwnerRepository.save(contactOwner);
    }

    @Override
    public ContactOwner updateContactOwner(UpdateContactOwnerDto updateDto) {

        ContactOwner contactOwner = contactOwnerRepository.findById(updateDto.getId())
                        .orElseThrow(()->new EntityNotFoundException("Такой владелец контакта не существует"));

        contactOwnerRepository.findByEmail(updateDto.getEmail())
                .ifPresent(co-> {
                    if (!co.getId().equals(updateDto.getId())) {
                        throw new ValidationException("email занят");
                    }
                });

        contactOwnerRepository.findByUsername(updateDto.getUsername())
                .stream()
                .findFirst()
                .ifPresent(co-> {
                    if (!co.getId().equals(updateDto.getId())) {
                        throw new ValidationException("username занят");
                    }
                });

        ContactOwner updateOwner = modelMapper.map(updateDto, ContactOwner.class);
        updateOwner.setRole(contactOwner.getRole());
        return contactOwnerRepository.save(updateOwner);
    }

    @Override
    public boolean deleteContactOwner(UUID id) {
        if (contactOwnerRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException("Указанный id не существует");
        }
        return contactOwnerRepository.deleteById(id);
    }

    @Override
    public List<ContactOwner> searchContactOwnersByUsername(String username) {
        return contactOwnerRepository.findByUsername(username);
    }

    @Override
    public List<ContactOwner> searchContactOwnersByKeyword(String keyword) {
        return contactOwnerRepository.searchByKeyword(keyword);
    }
}

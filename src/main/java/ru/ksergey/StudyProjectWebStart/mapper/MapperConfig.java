package ru.ksergey.StudyProjectWebStart.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.ksergey.StudyProjectWebStart.model.dto.*;
import ru.ksergey.StudyProjectWebStart.model.entity.Contact;
import ru.ksergey.StudyProjectWebStart.model.entity.ContactDetail;
import ru.ksergey.StudyProjectWebStart.model.entity.ContactOwner;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        mapper.getConfiguration()
                .setImplicitMappingEnabled(false)
                .setSkipNullEnabled(true);
        configureUpdateContactMapping(mapper);
        configureContactDetailMapping(mapper);
        configureContactMapping(mapper);
        configureContactOwnerMapping(mapper);
        configureUpdateContactOwnerMapping(mapper);


        return mapper;
    }

    private void configureUpdateContactMapping(ModelMapper mapper){
        mapper.typeMap(UpdateContactDto.class, Contact.class)
                .addMappings(m->{
                    m.map(UpdateContactDto::getFirstName,Contact::setFirstName);
                    m.map(UpdateContactDto::getLastName,Contact::setLastName);
                    m.map(UpdateContactDto::getTelephone,Contact::setTelephone);
                    m.map(UpdateContactDto::getEmail,Contact::setEmail);
                    m.map(UpdateContactDto::getContactDetail,Contact::setContactDetail);
                    m.skip(Contact::setOwner);
                    m.skip(Contact::setId);
                });
    }

    private void configureContactDetailMapping(ModelMapper mapper) {
        mapper.typeMap(ContactDetailDto.class, ContactDetail.class)
                .addMappings(m -> {
                    m.map(ContactDetailDto::getBirthDate, ContactDetail::setBirthDate);
                    m.map(ContactDetailDto::getCompany, ContactDetail::setCompany);
                    m.map(ContactDetailDto::getNotes, ContactDetail::setNotes);
                    m.map(ContactDetailDto::getSocialMediaProfile, ContactDetail::setSocialMediaProfile);
                    m.map(ContactDetailDto::getTags, ContactDetail::setTags);
                    m.skip(ContactDetail::setId);
                    m.skip(ContactDetail::setContact);
                });
    }

    private void configureContactMapping(ModelMapper mapper) {
        mapper.typeMap(CreateContactDto.class, Contact.class)
                .addMappings(m -> {
                    m.map(CreateContactDto::getFirstName, Contact::setFirstName);
                    m.map(CreateContactDto::getLastName, Contact::setLastName);
                    m.map(CreateContactDto::getTelephone, Contact::setTelephone);
                    m.map(CreateContactDto::getEmail, Contact::setEmail);
                    m.map(CreateContactDto::getContactDetail, Contact::setContactDetail);
                    m.skip(Contact::setOwner);
                    m.skip(Contact::setId);
                });
    }

    private void configureContactOwnerMapping(ModelMapper mapper) {
        mapper.typeMap(CreateContactOwnerDto.class, ContactOwner.class)
                .addMappings(m -> {
                    m.map(CreateContactOwnerDto::getUsername, ContactOwner::setUsername);
                    m.map(CreateContactOwnerDto::getDescription, ContactOwner::setDescription);
                    m.map(CreateContactOwnerDto::getEmail, ContactOwner::setEmail);
                    m.map(CreateContactOwnerDto::getPassword, ContactOwner::setPassword);
                    m.skip(ContactOwner::setId);
                    m.skip(ContactOwner::setRole);
                    m.skip(ContactOwner::setContacts);
                });
    }

    private void configureUpdateContactOwnerMapping(ModelMapper mapper) {
        mapper.typeMap(UpdateContactOwnerDto.class, ContactOwner.class)
                .addMappings(m -> {
                    m.map(UpdateContactOwnerDto::getUsername, ContactOwner::setUsername);
                    m.map(UpdateContactOwnerDto::getDescription, ContactOwner::setDescription);
                    m.map(UpdateContactOwnerDto::getEmail, ContactOwner::setEmail);
                    m.skip(ContactOwner::setId);
                    m.skip(ContactOwner::setRole);
                    m.skip(ContactOwner::setContacts);
                    m.skip(ContactOwner::setPassword);
                });

    }
}

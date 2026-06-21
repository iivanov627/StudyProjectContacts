package ru.ksergey.StudyProjectWebStart.service;

import ru.ksergey.StudyProjectWebStart.model.dto.CreateContactDto;
import ru.ksergey.StudyProjectWebStart.model.dto.UpdateContactDto;
import ru.ksergey.StudyProjectWebStart.model.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();

    Contact getContactById(int id);

    Contact createContact(CreateContactDto dto);

    Contact updateContact(UpdateContactDto dto);

    boolean deleteContact(int id);
}

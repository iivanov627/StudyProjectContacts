package ru.ksergey.StudyProjectWebStart.service;

import ru.ksergey.StudyProjectWebStart.model.dto.CreateContactOwnerDto;
import ru.ksergey.StudyProjectWebStart.model.dto.UpdateContactOwnerDto;
import ru.ksergey.StudyProjectWebStart.model.entity.ContactOwner;

import java.util.List;

public interface ContactOwnerService {
    List<ContactOwner> getAllContactOwners();
    ContactOwner getContactOwnerById(String id);
    ContactOwner createContactOwner(CreateContactOwnerDto createDto);
    ContactOwner updateContactOwner(UpdateContactOwnerDto updateDto);
    boolean deleteContactOwner(String id);
    List<ContactOwner> searchContactOwnersByUsername(String username);
    List<ContactOwner> searchContactOwnersByKeyword(String keyword);
}
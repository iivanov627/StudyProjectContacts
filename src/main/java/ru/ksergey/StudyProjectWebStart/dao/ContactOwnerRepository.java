package ru.ksergey.StudyProjectWebStart.dao;


import ru.ksergey.StudyProjectWebStart.model.entity.ContactOwner;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContactOwnerRepository {
    List<ContactOwner> findAll();
    Optional<ContactOwner> findById(UUID id);
    Optional<ContactOwner> findByEmail(String email);
    ContactOwner save(ContactOwner contactOwner);
    boolean deleteById(UUID id);
    List<ContactOwner> findByUsername(String username);
    List<ContactOwner> searchByKeyword(String keyword);

}

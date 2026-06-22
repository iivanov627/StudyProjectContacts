package ru.ksergey.StudyProjectWebStart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ksergey.StudyProjectWebStart.model.entity.Contact;

import java.util.Optional;

public interface JpaContactRepository extends JpaRepository<Contact, Integer> {
    Optional<Contact> findByEmail(String email);
    Optional<Contact> findByTelephone(String telephone);
}

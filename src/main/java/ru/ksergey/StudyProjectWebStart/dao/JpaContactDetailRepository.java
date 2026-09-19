package ru.ksergey.StudyProjectWebStart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ksergey.StudyProjectWebStart.model.entity.ContactDetail;


@Repository
public interface JpaContactDetailRepository extends JpaRepository<ContactDetail, Integer> {
}

package ru.ksergey.StudyProjectWebStart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ksergey.StudyProjectWebStart.model.entity.ContactOwner;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JpaContactOwnerRepository extends JpaRepository<ContactOwner, String> {
    Optional<ContactOwner> findByEmail(String email);
    List<ContactOwner> findByUsername(String username);

    @Query("SELECT co FROM ContactOwner co WHERE "+
            "LOWER(co.username) LIKE LOWER(CONCAT('%', :keyword, '%'))"+
            "OR LOWER(co.description) LIKE LOWER(CONCAT('%', :keyword, '%')) "+
            "OR LOWER(co.email) LIKE LOWER(CONCAT('%', :keyword, '%')) ")
    List<ContactOwner> searchByKeyword(@Param("keyword") String keyword);
}

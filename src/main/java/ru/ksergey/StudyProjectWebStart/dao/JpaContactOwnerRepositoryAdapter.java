package ru.ksergey.StudyProjectWebStart.dao;

import lombok.experimental.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.ksergey.StudyProjectWebStart.model.entity.ContactOwner;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Repository
public class JpaContactOwnerRepositoryAdapter implements ContactOwnerRepository{

    @Delegate
    private final JpaContactOwnerRepository jpaContactOwnerRepository;


    public JpaContactOwnerRepositoryAdapter(JpaContactOwnerRepository jpaContactOwnerRepository) {
        this.jpaContactOwnerRepository = jpaContactOwnerRepository;
    }

    @Override
    public ContactOwner save(ContactOwner contactOwner) {
        return jpaContactOwnerRepository.save(contactOwner);
    }

    @Override
    public boolean deleteById(UUID id){
        if (jpaContactOwnerRepository.existsById(id)){
            jpaContactOwnerRepository.deleteById(id);
            return !jpaContactOwnerRepository.existsById(id);
        } else {
            return false;
        }
    }


    //    @Override
//    public List<ContactOwner> findAll() {
//        return jpaContactOwnerRepository.findAll();
//    }
//
//    @Override
//    public Optional<ContactOwner> findById(UUID id) {
//        return jpaContactOwnerRepository.findById(id);
//    }
//
//    @Override
//    public Optional<ContactOwner> findByEmail(String email) {
//        return jpaContactOwnerRepository.findByEmail(email);
//    }
//
//    @Override
//    public ContactOwner save(ContactOwner contactOwner) {
//        return jpaContactOwnerRepository.save(contactOwner);
//    }
//
//    @Override
//    public boolean deleteById(UUID id) {
//        try {
//            jpaContactOwnerRepository.deleteById(id);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    @Override
//    public List<ContactOwner> findByUsername(String username) {
//        return jpaContactOwnerRepository.findByUsername(username);
//    }
//
//    @Override
//    public List<ContactOwner> searchByKeyword(String keyword) {
//        return jpaContactOwnerRepository.searchByKeyword(keyword);
//    }

}
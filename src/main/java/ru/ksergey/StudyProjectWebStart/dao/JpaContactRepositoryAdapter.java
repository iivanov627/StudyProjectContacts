package ru.ksergey.StudyProjectWebStart.dao;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.ksergey.StudyProjectWebStart.model.entity.Contact;

import java.util.List;
import java.util.Optional;

@Primary
@Repository
public class JpaContactRepositoryAdapter implements ContactRepository{
    private final JpaContactRepository jpaContactRepository;

    @Autowired
    public JpaContactRepositoryAdapter(JpaContactRepository jpaContactRepository) {
        this.jpaContactRepository = jpaContactRepository;
    }

    @Override
    public List<Contact> findAll() {
        return jpaContactRepository.findAll();
    }

    @Override
    public Optional<Contact> findById(int id) {
        return jpaContactRepository.findById(id);
    }

    @Override
    public Contact save(Contact contact) {
        return jpaContactRepository.save(contact);
    }

    @Override
    public boolean deleteById(int id) {
        try {
            jpaContactRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Optional<Contact> findByEmail(String email) {
        return jpaContactRepository.findByEmail(email);
    }

    @Override
    public Optional<Contact> findByTelephone(String telephone) {
        return jpaContactRepository.findByTelephone(telephone);
    }
}

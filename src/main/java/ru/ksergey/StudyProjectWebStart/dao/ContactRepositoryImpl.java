package ru.ksergey.StudyProjectWebStart.dao;

import org.springframework.stereotype.Repository;
import ru.ksergey.StudyProjectWebStart.model.entity.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContactRepositoryImpl implements ContactRepository {

    private final ArrayList<Contact> contacts = new ArrayList<>();

    public ContactRepositoryImpl() {
        for (int i = 1; i < 10; i++){
            contacts.add(new Contact(
                    i,
                    "+7 951 213 2323" +i,
                    "Ivan" +i,
                    "Tselikov" +i,
                    "user " + i + " @maisaf.com"
            ));}
    }

    @Override
    public List<Contact> findAll() {
        return new ArrayList<>(contacts);
    }

    @Override
    public Optional<Contact> findById(int id) {
        return contacts.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    @Override
    public Contact save(Contact contact) {
        if (contact.getId() == 0) {
            int newId = contacts.stream()
                    .mapToInt(Contact::getId)
                    .max()
                    .orElse(0) + 1;
            contact.setId(newId);
            contacts.add(contact);
        } else {
           int index = contacts.indexOf(
                   contacts.stream()
                   .filter(c->c.getId()== contact.getId())
                   .findFirst()
                   .orElse(null));

           if (index != -1){
               contacts.set(index,contact);
           }
        }
        return contact;
    }

    @Override
    public boolean deleteById(int id) {
        return contacts.removeIf(contact -> contact.getId() == id);
    }

    @Override
    public Optional<Contact> findByEmail(String email) {
        return contacts.stream()
                .filter(c->c.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    public Optional<Contact> findByTelephone(String telephone) {
        return contacts.stream()
                .filter(c->c.getTelephone().equals(telephone))
                .findFirst();
    }
}

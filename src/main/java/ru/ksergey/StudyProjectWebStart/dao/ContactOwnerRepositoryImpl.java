package ru.ksergey.StudyProjectWebStart.dao;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;
import ru.ksergey.StudyProjectWebStart.model.entity.ContactOwner;
import ru.ksergey.StudyProjectWebStart.model.enums.AppRole;

import java.util.*;
import java.util.stream.IntStream;

@Repository
public class ContactOwnerRepositoryImpl implements ContactOwnerRepository{

    private final List<ContactOwner> contactOwners;

    public ContactOwnerRepositoryImpl() {
        contactOwners = new ArrayList<>();
        Faker faker = new Faker(Locale.of("ru"));

        IntStream.range(0,5).forEach(i->{
            ContactOwner owner = new ContactOwner();
            owner.setId(UUID.randomUUID());
            owner.setUsername(faker.name().username());
            owner.setEmail(faker.internet().emailAddress());
            owner.setPassword(faker.internet()
                    .password(8,50,true,false,true));
            owner.setDescription(faker.lorem().sentence(10));
            owner.setRole(AppRole.USER);
            contactOwners.add(owner);
        });
    }

    @Override
    public List<ContactOwner> findAll() {
        return new ArrayList<>(contactOwners);
    }

    @Override
    public Optional<ContactOwner> findById(UUID id) {
        return contactOwners.stream()
                .filter(owner->owner.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<ContactOwner> findByEmail(String email) {
        return contactOwners.stream()
                .filter(co -> co.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    public ContactOwner save(ContactOwner contactOwner) {
        if (contactOwner.getId() == null){
            contactOwner.setId(UUID.randomUUID());
            contactOwner.setRole(AppRole.USER);
            contactOwners.add(contactOwner);
        } else {
            int index = contactOwners.indexOf(
                    contactOwners.stream()
                            .filter(co->co.getId().equals(contactOwner.getId()))
                            .findFirst()
                            .orElse(null)
            );

            if (index != -1){
                contactOwners.set(index, contactOwner);
            }

            return contactOwner;
        }

        return contactOwner;

    }

    @Override
    public boolean deleteById(UUID id) {
        return contactOwners.removeIf(co->co.getId().equals(id));
    }

    @Override
    public List<ContactOwner> findByUsername(String username) {
        return contactOwners.stream()
                .filter(co->co.getUsername().equalsIgnoreCase(username))
                .toList();
    }

    @Override
    public List<ContactOwner> searchByKeyword(String keyword) {
        return contactOwners.stream()
                .filter(co->
                    co.getUsername().toLowerCase().contains(keyword)
                    || co.getEmail().toLowerCase().contains(keyword)
                    || co.getDescription().toLowerCase().contains(keyword)
                ).toList();
    }
}

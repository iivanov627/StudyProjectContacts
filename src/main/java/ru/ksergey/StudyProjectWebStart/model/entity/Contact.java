package ru.ksergey.StudyProjectWebStart.model.entity;


import lombok.*;

import java.util.Objects;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private int id;
    private String telephone;
    private String firstName;
    private String lastName;
    private String email;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id == contact.id && Objects.equals(telephone, contact.telephone)
                && Objects.equals(firstName, contact.firstName)
                && Objects.equals(lastName, contact.lastName)
                && Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, telephone, firstName, lastName, email);
    }
}

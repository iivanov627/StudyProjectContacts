package ru.ksergey.StudyProjectWebStart.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.ksergey.StudyProjectWebStart.model.enums.AppRole;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Contact_owners")
@Setter
@Getter
public class ContactOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String username;
    private String description;
    private String email;
    @JsonIgnore
    private String password;
    @Enumerated(EnumType.STRING)
    private AppRole role;

    @OneToMany (
            mappedBy = "owner",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Contact> contacts = new ArrayList<>();

    public ContactOwner() {
    }

    public ContactOwner(String username, String description) {
        this();
        this.username = username;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        ContactOwner that = (ContactOwner) o;
        return Objects.equals(id, that.id)
                && Objects.equals(username, that.username)
                && Objects.equals(description, that.description)
                && Objects.equals(email, that.email)
                && Objects.equals(password, that.password)
                && role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, description, email, password, role);
    }
}

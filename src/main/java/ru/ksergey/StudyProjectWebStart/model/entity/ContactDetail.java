package ru.ksergey.StudyProjectWebStart.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table (name = "contact_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "company")
    private String company;

    @Column(name = "notes")
    private String notes;

    @Column(name = "social_media_profile")
    private String socialMediaProfile;

    @Column(name = "tags")
    private String tags;

    @JsonIgnore
    @JoinColumn(name = "contact_id")
    @OneToOne
    private Contact contact;
}

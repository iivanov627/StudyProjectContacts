package ru.ksergey.StudyProjectWebStart.model.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDetailDto {

    private LocalDate birthDate;
    private String company;
    private String notes;
    private String socialMediaProfile;
    private String tags;
}

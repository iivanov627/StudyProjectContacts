package ru.ksergey.StudyProjectWebStart.model.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateContactDto {
    @NotBlank(message = "Имя не может быть пустым")
    private String firstName;
    @NotBlank(message = "Фамилия не может быть пустой")
    private String lastName;
    @Pattern(regexp = "\\+7\\(\\d{3}\\)\\d{3} \\d{2} \\d{2}",
            message = "Неверный формат телефона")
    private String telephone;
    @Email(message = "Неккоректный email")
    private String email;

    private ContactDetailDto contactDetail;

    @NotNull(message = "ID владельца не может быть пустым")
    private String ownerId;
}

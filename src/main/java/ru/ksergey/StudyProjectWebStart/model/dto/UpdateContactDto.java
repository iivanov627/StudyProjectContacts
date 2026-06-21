package ru.ksergey.StudyProjectWebStart.model.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateContactDto {
    @NotNull(message = "id обязателен")
    private Integer id;
    @NotBlank (message = "Имя обязательно")
    @Size (min = 2, max = 50, message = "Длина имени от 2 до 50 символов")
    @Pattern(regexp = "^\\p{L}+$", message = "Имя должно быть только из букв" )
    private String firstName;
    @NotBlank (message = "Фамилия обязательна")
    @Size (min = 2, max = 50, message = "Длина фамилии от 2 до 50 символов")
    @Pattern(regexp = "^\\p{L}+$", message = "Фамилия должна быть только из букв" )
    private String lastName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Pattern(regexp = "\\+7\\(\\d{3}\\)\\d{3} \\d{2} \\d{2}",
            message = "Неверный формат телефона")
    private String telephone;
}

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
public class UpdateContactOwnerDto {
    @NotNull
    private String id;

    @NotBlank(message = "username required")
    @Size(min = 6, max = 50, message = "username size 6-50")
    private String username;

    @NotNull (message = "null unable")
    @Size (max = 100, message = "max description size 100")
    private String description;

    @NotBlank
    @Size (min = 2, max = 50, message = "name size 2-50")
    private String fullName;

    @NotBlank (message = "email required")
    @Email(message = "not supported type of email")
    private String email;

//    @NotBlank (message = "password required")
//    @Size (min = 6, max = 50, message = "password size 6-50")
//    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z0-9]{8,50}$",
//            message = "not supported type of password")
//    private String password;
}

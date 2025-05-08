package com.josmejia2401.nuevospa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserRequestDto {

    @NotBlank(message = "El nombre de usuario es obligatorio")
    @JsonProperty("username")
    private String username;

    @NotBlank(message = "La contraseña es obligatoria")
    @JsonProperty("password")
    private String password;

    @NotBlank(message = "El role es obligatorio")
    @JsonProperty("role")
    private String role;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email es invalido")
    @JsonProperty("email")
    private String email;
}


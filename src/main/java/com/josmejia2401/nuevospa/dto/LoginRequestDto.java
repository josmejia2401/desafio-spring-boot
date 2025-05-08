package com.josmejia2401.nuevospa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LoginRequestDto {
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
}


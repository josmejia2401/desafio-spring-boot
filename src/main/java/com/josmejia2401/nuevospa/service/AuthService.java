package com.josmejia2401.nuevospa.service;

import com.josmejia2401.nuevospa.dto.LoginRequestDto;
import com.josmejia2401.nuevospa.dto.LoginResponseDto;

public interface AuthService {
    LoginResponseDto login(LoginRequestDto loginRequest);
}

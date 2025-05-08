package com.josmejia2401.nuevospa.controller;

import com.josmejia2401.nuevospa.dto.LoginRequestDto;
import com.josmejia2401.nuevospa.dto.LoginResponseDto;
import com.josmejia2401.nuevospa.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request) {
        return ResponseEntity.ok(authService.login(request));
    }
}


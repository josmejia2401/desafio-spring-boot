package com.josmejia2401.nuevospa.service.impl;

import com.josmejia2401.nuevospa.dto.LoginRequestDto;
import com.josmejia2401.nuevospa.dto.LoginResponseDto;
import com.josmejia2401.nuevospa.logging.Logger;
import com.josmejia2401.nuevospa.repository.UsuarioRepository;
import com.josmejia2401.nuevospa.security.JwtUtil;
import com.josmejia2401.nuevospa.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Description("Servicio para iniciar sesión")
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Logger
    public LoginResponseDto login(LoginRequestDto loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(), loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return new LoginResponseDto(jwt);
    }
}


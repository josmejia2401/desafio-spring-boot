package com.josmejia2401.nuevospa.service.impl;

import com.josmejia2401.nuevospa.dto.UserRequestDto;
import com.josmejia2401.nuevospa.dto.UserResponseDto;
import com.josmejia2401.nuevospa.entity.Usuario;
import com.josmejia2401.nuevospa.errors.ResourceNotFoundException;
import com.josmejia2401.nuevospa.repository.UsuarioRepository;
import com.josmejia2401.nuevospa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UsuarioRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UsuarioRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto request) {
        Usuario user = new Usuario();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        Usuario saved = userRepository.save(user);
        return toResponse(saved);
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto request) {
        Usuario user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        return toResponse(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        Usuario user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        userRepository.delete(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        Usuario user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        return toResponse(user);
    }

    private UserResponseDto toResponse(Usuario user) {
        return new UserResponseDto(user.getId(), user.getUsername(), user.getEmail(), user.getRole());
    }
}

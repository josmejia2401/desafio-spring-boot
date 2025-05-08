package com.josmejia2401.nuevospa.service;

import com.josmejia2401.nuevospa.dto.UserRequestDto;
import com.josmejia2401.nuevospa.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto request);
    UserResponseDto updateUser(Long id, UserRequestDto request);
    void deleteUser(Long id);
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUserById(Long id);
}

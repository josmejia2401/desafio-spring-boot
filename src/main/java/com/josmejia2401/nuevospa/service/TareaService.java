package com.josmejia2401.nuevospa.service;

import com.josmejia2401.nuevospa.dto.TareaRequestDto;
import com.josmejia2401.nuevospa.dto.TareaResponseDto;

import java.util.List;

public interface TareaService {
    List<TareaResponseDto> listarPorUsuario(String username);
    TareaResponseDto crear(String username, TareaRequestDto dto);
    TareaResponseDto actualizar(Long id, String username, TareaRequestDto dto);
    void eliminar(Long id, String username);
}

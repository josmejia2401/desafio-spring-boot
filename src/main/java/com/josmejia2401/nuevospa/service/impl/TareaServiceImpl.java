package com.josmejia2401.nuevospa.service.impl;

import com.josmejia2401.nuevospa.dto.TareaRequestDto;
import com.josmejia2401.nuevospa.dto.TareaResponseDto;
import com.josmejia2401.nuevospa.entity.*;
import com.josmejia2401.nuevospa.errors.ResourceNotFoundException;
import com.josmejia2401.nuevospa.repository.*;
import com.josmejia2401.nuevospa.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EstadoTareaRepository estadoTareaRepository;

    public List<TareaResponseDto> listarPorUsuario(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username).orElseThrow();
        return tareaRepository.findByUsuario(usuario).stream().map(this::toDto).collect(Collectors.toList());
    }

    public TareaResponseDto crear(String username, TareaRequestDto dto) {
        Usuario usuario = usuarioRepository.findByUsername(username).orElseThrow();
        EstadoTarea estado = estadoTareaRepository.findById(dto.getEstadoId()).orElseThrow();

        Tarea tarea = new Tarea();
        tarea.setNombre(dto.getNombre());
        tarea.setDescripcion(dto.getDescripcion());
        tarea.setEstado(estado);
        tarea.setUsuario(usuario);

        return toDto(tareaRepository.save(tarea));
    }

    public TareaResponseDto actualizar(Long id, String username, TareaRequestDto dto) {
        Tarea tarea = tareaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Registro no existe"));
        if (!tarea.getUsuario().getUsername().equals(username)) {
            throw new SecurityException("No autorizado");
        }
        EstadoTarea estado = estadoTareaRepository.findById(dto.getEstadoId()).orElseThrow();

        tarea.setNombre(dto.getNombre());
        tarea.setDescripcion(dto.getDescripcion());
        tarea.setEstado(estado);

        return toDto(tareaRepository.save(tarea));
    }

    public void eliminar(Long id, String username) {
        Tarea tarea = tareaRepository.findById(id).orElseThrow();
        if (!tarea.getUsuario().getUsername().equals(username)) {
            throw new SecurityException("No autorizado");
        }
        tareaRepository.delete(tarea);
    }

    private TareaResponseDto toDto(Tarea tarea) {
        TareaResponseDto dto = new TareaResponseDto();
        dto.setId(tarea.getId());
        dto.setNombre(tarea.getNombre());
        dto.setDescripcion(tarea.getDescripcion());
        dto.setEstado(tarea.getEstado().getNombre());
        dto.setUsuario(tarea.getUsuario().getUsername());
        dto.setFechaCreacion(tarea.getFechaCreacion());
        return dto;
    }
}


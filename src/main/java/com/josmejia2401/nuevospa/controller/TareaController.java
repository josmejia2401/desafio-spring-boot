package com.josmejia2401.nuevospa.controller;

import com.josmejia2401.nuevospa.dto.TareaRequestDto;
import com.josmejia2401.nuevospa.dto.TareaResponseDto;
import com.josmejia2401.nuevospa.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping
    public ResponseEntity<List<TareaResponseDto>> listar(Authentication auth) {
        return ResponseEntity.ok(tareaService.listarPorUsuario(auth.getName()));
    }

    @PostMapping
    public ResponseEntity<TareaResponseDto> crear(Authentication auth, @RequestBody TareaRequestDto dto) {
        return ResponseEntity.ok(tareaService.crear(auth.getName(), dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TareaResponseDto> actualizar(
            @PathVariable Long id,
            Authentication auth,
            @RequestBody TareaRequestDto dto) {
        return ResponseEntity.ok(tareaService.actualizar(id, auth.getName(), dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id, Authentication auth) {
        tareaService.eliminar(id, auth.getName());
        return ResponseEntity.noContent().build();
    }
}


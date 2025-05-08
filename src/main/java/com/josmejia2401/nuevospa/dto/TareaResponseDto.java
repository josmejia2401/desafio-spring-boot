package com.josmejia2401.nuevospa.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TareaResponseDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private String estado;
    private String usuario;
    private LocalDateTime fechaCreacion;
}


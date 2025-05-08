package com.josmejia2401.nuevospa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TareaRequestDto {
    @NotBlank(message = "El campo Nombre no puede ser vacío")
    @NotBlank(message = "El campo Nombre es requerido")
    private String nombre;
    private String descripcion;
    @NotNull(message = "El campo estado es requerido")
    private Long estadoId;
}


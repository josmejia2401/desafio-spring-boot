package com.josmejia2401.nuevospa.repository;

import com.josmejia2401.nuevospa.entity.EstadoTarea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoTareaRepository extends JpaRepository<EstadoTarea, Long> {
    Optional<EstadoTarea> findByNombre(String nombre);
}

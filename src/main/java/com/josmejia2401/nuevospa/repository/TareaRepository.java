package com.josmejia2401.nuevospa.repository;

import com.josmejia2401.nuevospa.entity.Tarea;
import com.josmejia2401.nuevospa.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByUsuario(Usuario usuario);
}

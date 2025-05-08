package com.josmejia2401.nuevospa.service.impl;

import com.josmejia2401.nuevospa.entity.EstadoTarea;
import com.josmejia2401.nuevospa.repository.EstadoTareaRepository;
import com.josmejia2401.nuevospa.service.EstadoTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoTareaServiceImpl implements EstadoTareaService {
    @Autowired
    private EstadoTareaRepository estadoTareaRepository;

    public List<EstadoTarea> listarTodos() {
        return estadoTareaRepository.findAll();
    }
}


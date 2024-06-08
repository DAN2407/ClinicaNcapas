package com.springdemo.clinica.services;

import com.springdemo.clinica.models.dtos.CreateHistorialDTO;
import com.springdemo.clinica.models.entities.Historial;

import java.util.List;
import java.util.UUID;

public interface HistorialService {
    List<Historial> findAll();
    void createHistorial(CreateHistorialDTO historial);
    Historial findById(UUID id);
}


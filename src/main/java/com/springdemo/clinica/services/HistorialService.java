package com.springdemo.clinica.services;

import com.springdemo.clinica.models.dtos.CreateHistorialDTO;
import com.springdemo.clinica.models.entities.Historial;

import java.util.List;

public interface HistorialService {
    void create(CreateHistorialDTO info);
    List<Historial> findAll();
}

package com.springdemo.clinica.services;

import com.springdemo.clinica.models.dtos.CreatePreinscripcionDTO;
import com.springdemo.clinica.models.entities.PreInscripcion;

import java.util.List;

public interface PreInscripcionService {
    void save(CreatePreinscripcionDTO info);
    List<PreInscripcion> findAll();

}

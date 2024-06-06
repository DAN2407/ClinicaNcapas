package com.springdemo.clinica.services;

import com.springdemo.clinica.models.dtos.CreateCitaMedicaDTO;
import com.springdemo.clinica.models.entities.CitaMedica;

import java.util.List;
import java.util.UUID;

public interface CitaMedicaService {
    void create(CreateCitaMedicaDTO info);
    void delete(UUID id);
    List<CitaMedica> findAll();
}

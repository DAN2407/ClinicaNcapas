package com.springdemo.clinica.services;

import com.springdemo.clinica.models.dtos.CreateCitaMedicaDTO;
import com.springdemo.clinica.models.entities.CitaMedica;

import java.util.List;
import java.util.UUID;

public interface CitaMedicaService {

    void save(CreateCitaMedicaDTO info);
    void delete(UUID code);
    List<CitaMedica> getAll();
    CitaMedica getByCode(UUID code);
    void update(UUID code, CreateCitaMedicaDTO info);

}

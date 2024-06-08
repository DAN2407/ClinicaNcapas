package com.springdemo.clinica.services;

import com.springdemo.clinica.models.dtos.CreatePreinscripcionDTO;

import java.util.List;
import java.util.UUID;

public interface PreInscripcionService {

    void save(CreatePreinscripcionDTO info);
    void delete(UUID code);
}

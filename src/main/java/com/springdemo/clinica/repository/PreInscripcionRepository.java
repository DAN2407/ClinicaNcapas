package com.springdemo.clinica.repository;

import com.springdemo.clinica.models.entities.PreInscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PreInscripcionRepository extends JpaRepository<PreInscripcion, UUID> {
    void deleteByCode(UUID code);
    PreInscripcion findByCode(UUID code);

}

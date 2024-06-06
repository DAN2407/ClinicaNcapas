package com.springdemo.clinica.repository;

import com.springdemo.clinica.models.entities.PreInscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PreInscripcionRepository extends JpaRepository<PreInscripcion, UUID> {
    Optional<PreInscripcion> save(String nombre);
    Optional<PreInscripcion> findById(String s);
    Optional<PreInscripcion> deleteByNombre(String nombre);
}
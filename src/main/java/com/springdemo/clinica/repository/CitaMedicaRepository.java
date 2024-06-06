package com.springdemo.clinica.repository;

import com.springdemo.clinica.models.entities.CitaMedica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CitaMedicaRepository extends JpaRepository<CitaMedica, String> {
    Optional<CitaMedica> save(String nombre);
    Optional<CitaMedica> findById(UUID id);
    Optional<CitaMedica> deleteById(UUID id);
}

package com.springdemo.clinica.repository;

import com.springdemo.clinica.models.dtos.CreateHistorialDTO;
import com.springdemo.clinica.models.entities.Historial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HistorialRepository extends JpaRepository<Historial, String>{

    void deleteByCode(UUID code);

    Optional<Historial> findByCode(UUID code);
}

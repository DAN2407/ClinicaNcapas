package com.springdemo.clinica.repository;

import com.springdemo.clinica.models.dtos.CreateHistorialDTO;
import com.springdemo.clinica.models.entities.Historial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistorialRepository extends JpaRepository<Historial, String>{
    void create(CreateHistorialDTO info);
    List<Historial> findAll();
}

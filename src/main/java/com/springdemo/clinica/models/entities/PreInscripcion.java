package com.springdemo.clinica.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "pre_inscripcion")
@Data
public class PreInscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID code;
    private String nombre;
    private String fecha;
    private String hora;
    private String motivo;
    private String diagnostico;
    private String tratamiento;
}

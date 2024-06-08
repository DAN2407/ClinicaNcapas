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

    private String fecha_final;
    private String medicamento;
    private String Dosis;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cita_medica_id", nullable = false)
    private CitaMedica citaMedica;
}

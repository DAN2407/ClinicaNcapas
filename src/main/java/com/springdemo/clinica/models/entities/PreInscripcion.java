package com.springdemo.clinica.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;
@Data
@Entity
@Table(name = "pre_inscripcion")
public class PreInscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID code;

    private Date fecha_final;
    private String medicamento;
    private String dosis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cita_medica_id", nullable = false)
    private CitaMedica citaMedica;
}

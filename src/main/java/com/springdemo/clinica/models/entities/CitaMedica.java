package com.springdemo.clinica.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cita_medica")
@Data
public class CitaMedica {
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

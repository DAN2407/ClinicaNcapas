package com.springdemo.clinica.models.dtos;

import lombok.Data;

@Data
public class CreateHistorialDTO {
    private String fecha;
    private String hora;
    private String motivo;
    private String diagnostico;
    private String tratamiento;
}

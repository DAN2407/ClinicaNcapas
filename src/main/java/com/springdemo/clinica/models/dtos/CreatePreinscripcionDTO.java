package com.springdemo.clinica.models.dtos;

import lombok.Data;

import java.sql.Date;

@Data
public class CreatePreinscripcionDTO {
    private Date fecha_final;
    private String medicamento;
    private String dosis;
}

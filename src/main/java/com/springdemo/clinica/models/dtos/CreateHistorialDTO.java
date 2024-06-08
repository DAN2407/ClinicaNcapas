package com.springdemo.clinica.models.dtos;

import lombok.Data;

import java.sql.Date;

@Data
public class CreateHistorialDTO {
    private Date fecha;
    private String razon;
    private String correo;
}

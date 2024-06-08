package com.springdemo.clinica.models.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CreateHistorialDTO {
    private Date fecha;
    private String razon;
}

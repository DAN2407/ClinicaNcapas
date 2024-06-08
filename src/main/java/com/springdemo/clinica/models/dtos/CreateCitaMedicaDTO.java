package com.springdemo.clinica.models.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CreateCitaMedicaDTO {
    private Date f_realizacion;
    private Date f_finalizacion;;
    private Date f_solicitada;
    private String razon;
    private String estado;
    private Date f_estimada_final;
}

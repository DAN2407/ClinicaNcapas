package com.springdemo.clinica.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_x_cita")
public class UserXCita {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String code;

    private String fecha;
    private String hora;
    private String motivo;
    private String diagnostico;
    private String tratamiento;

    //llaves foraneas

    private String idUser;

    private String idCita;
}

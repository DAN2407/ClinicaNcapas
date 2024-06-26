package com.springdemo.clinica.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "user_x_cita")
public class UserXCita {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String code;

    private Date f_realizacion;
    private Date f_finalizacion;;
    private Date f_solicitada;
    private String razon;
    private boolean estado;
    private Date f_estimada_final;

    //LLAVES FORANEAS

    //Llave de usuario
    @ManyToOne(fetch = FetchType.EAGER)
    //user_id es el nombre de la comlumna en la tabla UserXCita
    @JoinColumn(name = "user_id", referencedColumnName = "code")
    private User user;

    //Llave de CitaMedica
    @ManyToOne(fetch = FetchType.EAGER)
    //cita_medica_id es el nombre de la comlumna en la tabla UserXCita
    @JoinColumn(name = "cita_medica_id", referencedColumnName = "code")
    private CitaMedica citaMedica;

    //Llave foranea con Espesialidad
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "especialidad_id", referencedColumnName = "code")
    private Especialidad especialidad;
}

package com.springdemo.clinica.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "historial")
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID code;

    private Date fecha;
    private String razon;


    //Relación uno a muchos con la tabla Historial, un usuario puede tener varios historiales
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}


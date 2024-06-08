package com.springdemo.clinica.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "especialidad")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID code;

    private String nombre;

    //Creando la relacion con tabla cruz UserXCita
    @OneToMany(mappedBy = "especialidad",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<UserXCita> userXCitas;
}

package com.springdemo.clinica.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;

    //Creando la relacion con la tabla usuario de N:N
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    @JsonIgnore
    private List<User> users;
}

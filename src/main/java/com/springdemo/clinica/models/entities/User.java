package com.springdemo.clinica.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID code;

    private String nombre_usuario;
    private String correo;
    private String contrasena;
    private String telefono;

    @Column(name = "documento_de_identidad")
    private String documentoDeIdentidad;

    // Relación 1:N con Historial
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Historial> historiales;


    //Creando la relacion con la tabla rol N:N
    //Para crear estas tablas N:N de esta forma se agrega
    //a la tabla con entidad fuerte, relacion fuerte
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            //Nombre de la tabla intermedia
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "user_id"), // Llave foranea de la tabla actual
            inverseJoinColumns = @JoinColumn(name = "role_id") // Llave foranea de la tabla roles
    )
    private List<Role> roles;


    //Creando la relacion con la tabla UserXCitaXespecialidad
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<UserXCita> userXCitas;

    //Creando relacion directa con cita_medica
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CitaMedica> citaMedicas;
}

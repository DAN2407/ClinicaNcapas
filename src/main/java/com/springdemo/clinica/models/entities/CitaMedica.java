package com.springdemo.clinica.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cita_medica")
@Data
public class CitaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID code;

    private String nombre;
    private String fecha;
    private String hora;
    private String motivo;
    private String diagnostico;
    private String tratamiento;


    //LLAVES FORANEAS -> citaMedica es el nombre de la variable en la clase UserXCita
    @OneToMany(mappedBy = "citaMedica", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<UserXCita> userXCitas;

    //Llave de usuario
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "code")
    private User user;


}

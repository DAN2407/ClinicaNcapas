package com.springdemo.clinica.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
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

    private Date fecha_realizacion;
    private Date fecha_finalizacion;
    private Date fecha_solicitud;
    private String razon;
    private String estado;
    private Date fecha_estimada_finalizacion;

    //LLAVES FORANEAS -> citaMedica es el nombre de la variable en la clase UserXCita
    @OneToMany(mappedBy = "citaMedica", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<UserXCita> userXCitas;

    //Llave de usuario
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "code")
    private User user;


}

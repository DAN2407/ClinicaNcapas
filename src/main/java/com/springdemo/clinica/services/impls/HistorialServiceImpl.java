package com.springdemo.clinica.services.impls;

import com.springdemo.clinica.models.dtos.CreateHistorialDTO;
import com.springdemo.clinica.models.entities.Historial;
import com.springdemo.clinica.repository.HistorialRepository;
import com.springdemo.clinica.services.HistorialService;
import com.springdemo.clinica.services.UserService;
import com.springdemo.clinica.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HistorialServiceImpl implements HistorialService {
    //Exportando el repositorio que se conecta a la base de datos
    //a la tabla de historial
    @Autowired
    private HistorialRepository historialRepository;
    @Autowired
    private UserService userService;

    @Override
    public List<Historial> findAll() {
        return null;
    }

    @Override
    public void createHistorial(CreateHistorialDTO historial) {
        User user = userService.findByEmail(historial.getCorreo());
        if (user == null) {
            throw new RuntimeException("Error en el usuario, no existe");
        }
        Historial newHistorial = new Historial();
        newHistorial.setRazon(historial.getRazon());
        newHistorial.setFecha(historial.getFecha());
        newHistorial.setUser(user);
        historialRepository.save(newHistorial);
    }

    @Override
    public Historial findById(UUID id) {
        return historialRepository.findByCode(id);
    }
}

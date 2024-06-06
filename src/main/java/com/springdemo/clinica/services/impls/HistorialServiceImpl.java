package com.springdemo.clinica.services.impls;

import com.springdemo.clinica.models.dtos.CreateHistorialDTO;
import com.springdemo.clinica.models.entities.Historial;
import com.springdemo.clinica.services.HistorialService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialServiceImpl implements HistorialService {
    @Override
    public void create(CreateHistorialDTO info) {

    }

    @Override
    public List<Historial> findAll() {
        return List.of();
    }
}

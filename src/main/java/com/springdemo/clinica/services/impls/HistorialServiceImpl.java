package com.springdemo.clinica.services.impls;

import com.springdemo.clinica.models.dtos.CreateHistorialDTO;
import com.springdemo.clinica.models.entities.Historial;
import com.springdemo.clinica.repository.HistorialRepository;
import com.springdemo.clinica.services.HistorialService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialServiceImpl implements HistorialService {

    private final HistorialRepository historialRepository;

    public HistorialServiceImpl(HistorialRepository historialRepository) {
        this.historialRepository = historialRepository;
    }

    @Override
    public void create(CreateHistorialDTO info) {
        historialRepository.create(info);
    }

    @Override
    public List<Historial> findAll() {
        return historialRepository.findAll();
    }
}

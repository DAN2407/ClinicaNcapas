package com.springdemo.clinica.services.impls;

import com.springdemo.clinica.models.dtos.CreateHistorialDTO;
import com.springdemo.clinica.models.entities.Historial;
import com.springdemo.clinica.repository.HistorialRepository;
import com.springdemo.clinica.services.HistorialService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HistorialServiceImpl implements HistorialService {

    private final HistorialRepository historialRepository;

    public HistorialServiceImpl(HistorialRepository historialRepository) {
        this.historialRepository = historialRepository;
    }


    @Override
    public List<Historial> findAll() {
        return historialRepository.findAll();
    }

    @Override
    public Historial findByCode(UUID code){
        return historialRepository.findByCode(code).orElse(null);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void save(CreateHistorialDTO info) {
        Historial historial = new Historial();
        historial.setFecha(info.getFecha());
        historial.setHora(info.getHora());
        historial.setMotivo(info.getMotivo());
        historial.setDiagnostico(info.getDiagnostico());
        historial.setTratamiento(info.getTratamiento());

        historialRepository.save(historial);
    }

    @Override
    public void delete(UUID code) {
        historialRepository.deleteByCode(code);
    }

}

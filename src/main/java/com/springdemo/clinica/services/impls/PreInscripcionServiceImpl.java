package com.springdemo.clinica.services.impls;

import com.springdemo.clinica.models.dtos.CreatePreinscripcionDTO;
import com.springdemo.clinica.models.entities.PreInscripcion;
import com.springdemo.clinica.repository.PreInscripcionRepository;
import com.springdemo.clinica.services.PreInscripcionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreInscripcionServiceImpl implements PreInscripcionService {

    private final PreInscripcionRepository preInscripcionRepository;

    public PreInscripcionServiceImpl(PreInscripcionRepository preInscripcionRepository) {
        this.preInscripcionRepository = preInscripcionRepository;
    }


    @Override
    public void save(CreatePreinscripcionDTO info) {
        PreInscripcion preInscripcion = new PreInscripcion();
        preInscripcion.setNombre(info.getNombre());
        preInscripcion.setFecha(info.getFecha());
        preInscripcion.setHora(info.getHora());
        preInscripcion.setMotivo(info.getMotivo());
        preInscripcion.setDiagnostico(info.getDiagnostico());
        preInscripcion.setTratamiento(info.getTratamiento());

        preInscripcionRepository.save(preInscripcion);
    }

    @Override
    public List<PreInscripcion> findAll() {
        return preInscripcionRepository.findAll();
    }
}

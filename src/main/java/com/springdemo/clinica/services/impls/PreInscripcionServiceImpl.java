package com.springdemo.clinica.services.impls;

import com.springdemo.clinica.models.dtos.CreatePreinscripcionDTO;
import com.springdemo.clinica.models.entities.PreInscripcion;
import com.springdemo.clinica.repository.PreInscripcionRepository;
import com.springdemo.clinica.services.PreInscripcionService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PreInscripcionServiceImpl implements PreInscripcionService {

    private final PreInscripcionRepository preInscripcionRepository;

    public PreInscripcionServiceImpl(PreInscripcionRepository preInscripcionRepository) {
        this.preInscripcionRepository = preInscripcionRepository;
    }

    @Override
    public void save(CreatePreinscripcionDTO info) {
        PreInscripcion preInscripcion = new PreInscripcion();

        preInscripcion.setDosis(info.getDosis());
        preInscripcion.setFecha_final(info.getFecha_final());
        preInscripcion.setMedicamento(info.getMedicamento());

        preInscripcionRepository.save(preInscripcion);
    }

    @Override
    public void delete(UUID code) {
        preInscripcionRepository.deleteByCode(code);
    }


}

package com.springdemo.clinica.services.impls;

import com.springdemo.clinica.models.dtos.CreateCitaMedicaDTO;
import com.springdemo.clinica.models.entities.CitaMedica;
import com.springdemo.clinica.repository.CitaMedicaRepository;
import com.springdemo.clinica.services.CitaMedicaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CitaMedicaServiceImpl implements CitaMedicaService {

    private final CitaMedicaRepository citaMedicaRepository;

    public CitaMedicaServiceImpl(CitaMedicaRepository citaMedicaRepository) {
        this.citaMedicaRepository = citaMedicaRepository;
    }

    @Override
    public void save(CreateCitaMedicaDTO info) {
        CitaMedica citaMedica = new CitaMedica();

        citaMedica.setF_realizacion(info.getF_realizacion());
        citaMedica.setF_finalizacion(info.getF_finalizacion());
        citaMedica.setF_solicitada(info.getF_solicitada());
        citaMedica.setRazon(info.getRazon());
        citaMedica.setEstado(info.getEstado());
        citaMedica.setF_estimada_final(info.getF_estimada_final());

        citaMedicaRepository.save(citaMedica);
    }

    @Override
    public void delete(UUID code) {
        citaMedicaRepository.deleteByCode(code);
    }

    @Override
    public List<CitaMedica> getAll() {
        return citaMedicaRepository.findAll();
    }

    @Override
    public CitaMedica getByCode(UUID code) {
        return citaMedicaRepository.findByCode(code).orElse(null);
    }

    @Override
    public void update(UUID code, CreateCitaMedicaDTO info) {
        CitaMedica citaMedica = citaMedicaRepository.findByCode(code).orElse(null);

        if (citaMedica != null) {
            citaMedica.setF_realizacion(info.getF_realizacion());
            citaMedica.setF_finalizacion(info.getF_finalizacion());
            citaMedica.setF_solicitada(info.getF_solicitada());
            citaMedica.setRazon(info.getRazon());
            citaMedica.setEstado(info.getEstado());
            citaMedica.setF_estimada_final(info.getF_estimada_final());

            citaMedicaRepository.save(citaMedica);
        }
    }
}

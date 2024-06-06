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
    public void create(CreateCitaMedicaDTO info) {
        CitaMedica citaMedica = new CitaMedica();
        citaMedica.setFecha(info.getFecha());
        citaMedica.setHora(info.getHora());
        citaMedica.setMotivo(info.getMotivo());
        citaMedica.setDiagnostico(info.getDiagnostico());
        citaMedica.setTratamiento(info.getTratamiento());

        citaMedicaRepository.save(citaMedica);
    }

    @Override
    public void delete(UUID id) {
        citaMedicaRepository.deleteById(id);
    }

    @Override
    public List<CitaMedica> findAll() {
        return citaMedicaRepository.findAll();
    }
}

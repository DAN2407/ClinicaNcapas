package com.springdemo.clinica.controller;

import com.springdemo.clinica.models.dtos.CreateHistorialDTO;
import com.springdemo.clinica.models.entities.Historial;
import com.springdemo.clinica.services.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/historial")
//@CrossOrigin("*")
public class HistorialController {
    @Autowired
    private HistorialService historialService;
  @PostMapping("/add-historial")
    public ResponseEntity<String> AddHistorial(@RequestBody CreateHistorialDTO createHistorialDTO) {
        historialService.createHistorial(createHistorialDTO);
        return ResponseEntity.ok("Historial added successfully");
    }
    @GetMapping("/all-historial")
    public ResponseEntity<String> getAllHistorial() {
        return ResponseEntity.ok("Historial found successfully");
    }
    @PostMapping("/find-historial")
    public ResponseEntity<Historial> getHistorialById( @RequestBody UUID id) {
        Historial historial = historialService.findById(id);
        return ResponseEntity.ok(historial);
    }
}

package com.capriccio.backend.controller;

import com.capriccio.backend.entity.Insumo;
import com.capriccio.backend.repository.InsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insumos")
@CrossOrigin(origins = "*") // Esto permite que tu JavaScript se conecte sin bloqueos
public class InsumoController {

    @Autowired
    private InsumoRepository insumoRepository;

    // Endpoint para obtener todos los insumos
    @GetMapping
    public List<Insumo> listarInsumos() {
        return insumoRepository.findAll();
    }

    // Endpoint para guardar un nuevo insumo (desde el formulario)
    @PostMapping
    public Insumo guardarInsumo(@RequestBody Insumo insumo) {
        return insumoRepository.save(insumo);
    }
}
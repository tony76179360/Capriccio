package com.capriccio.backend.controller;

import com.capriccio.backend.entity.OrdenProduccion;
import com.capriccio.backend.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {
    
    @Autowired
    private OrdenRepository ordenRepository;

    @GetMapping("/pendientes")
    public List<OrdenProduccion> listarPendientes() {
        return ordenRepository.findByEstado("Pendiente");
    }

    @PostMapping
    public OrdenProduccion crearOrden(@RequestBody OrdenProduccion orden) {
        return ordenRepository.save(orden);
    }

    @GetMapping("/en-proceso")
    public List<OrdenProduccion> listarEnProceso() {
        return ordenRepository.findByEstado("En Proceso");
    }

    @GetMapping("/completadas")
    public List<OrdenProduccion> listarCompletadas() {
        return ordenRepository.findByEstado("Completado");
    }
    // Método general para listar TODAS las órdenes
    @GetMapping
    public List<OrdenProduccion> listarTodas() {
        return ordenRepository.findAll();
    }
}
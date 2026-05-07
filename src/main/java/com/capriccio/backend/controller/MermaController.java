package com.capriccio.backend.controller;

import com.capriccio.backend.entity.Insumo;
import com.capriccio.backend.entity.RegistroMerma;
import com.capriccio.backend.repository.InsumoRepository;
import com.capriccio.backend.repository.MermaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/mermas")
public class MermaController {

    @Autowired
    private MermaRepository mermaRepository;

    @Autowired
    private InsumoRepository insumoRepository;

    @PostMapping
    public RegistroMerma guardarMerma(@RequestBody RegistroMerma merma) {
        // 1. Buscar el insumo para saber su costo actual
        Insumo insumoDb = insumoRepository.findById(merma.getInsumo().getIdInsumo())
                .orElseThrow(() -> new RuntimeException("Insumo no encontrado"));

        // 2. Calcular el costo de la pérdida automáticamente
        BigDecimal costoTotal = merma.getCantidadperdida().multiply(insumoDb.getCostoUnitario());
        merma.setCostofinancierocal(costoTotal);

        // 3. Regla de negocio: Si se pierden más de 50 soles, alertar al administrador
        if (costoTotal.doubleValue() > 50.00) {
            merma.setRequiereauditoria(true);
        }

        // 4. Guardar en la base de datos
        return mermaRepository.save(merma);
    }

    @GetMapping
    public List<RegistroMerma> listarMermas() {
        return mermaRepository.findAll();
    }
}
package com.capriccio.backend.controller;

import com.capriccio.backend.entity.Insumo;
import com.capriccio.backend.entity.OrdenProduccion;
import com.capriccio.backend.entity.RegistroMerma;
import com.capriccio.backend.repository.InsumoRepository;
import com.capriccio.backend.repository.MermaRepository;
import com.capriccio.backend.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/mermas")
public class MermaController {

    @Autowired private MermaRepository mermaRepository;
    @Autowired private InsumoRepository insumoRepository;
    @Autowired private OrdenRepository ordenRepository; // Inyectamos las órdenes

    @PostMapping
    public RegistroMerma guardarMerma(@RequestBody RegistroMerma merma) {
        Insumo insumoDb = insumoRepository.findById(merma.getInsumo().getIdInsumo()).orElseThrow();

        // 1. Costo Financiero
        BigDecimal costoTotal = merma.getCantidadperdida().multiply(insumoDb.getCostoUnitario());
        merma.setCostofinancierocal(costoTotal);

        // 2 Logica 
        if (merma.getIdorden() != null) {
            OrdenProduccion orden = ordenRepository.findById(merma.getIdorden()).orElse(null);
            
            if (orden != null && orden.getCantidadSolicitada() > 0) {
                // Calcular % de desviación (Perdida vs Solicitada)
                double porcentaje = (merma.getCantidadperdida().doubleValue() / orden.getCantidadSolicitada()) * 100;
                merma.setDesviacionPorcentaje(BigDecimal.valueOf(porcentaje));

                // ¿Es reutilizable y la desviación es > 5%? O ¿Supera los 50 soles?
                if ((merma.getEsReutilizable() && porcentaje > 5.0) || costoTotal.doubleValue() > 50.00) {
                    merma.setRequiereauditoria(true);
                    merma.setEstadoAuditoria("Requiere Cierre"); // Dispara la alerta crítica
                }
            }
        } else if (costoTotal.doubleValue() > 50.00) {
            merma.setRequiereauditoria(true);
            merma.setEstadoAuditoria("Requiere Cierre");
        }

        return mermaRepository.save(merma);
    }

    @GetMapping
    public List<RegistroMerma> listarMermas() {
        return mermaRepository.findAll();
    }

    // 3. NUEVO ENDPOINT: Registrar Cierre de Incidente (El final de tu diagrama)
    @PutMapping("/{id}/cerrar")
    public RegistroMerma cerrarIncidente(@PathVariable Integer id) {
        RegistroMerma merma = mermaRepository.findById(id).orElseThrow();
        merma.setEstadoAuditoria("Cerrado");
        merma.setRequiereauditoria(false); // Apagamos la alerta
        return mermaRepository.save(merma);
    }
}
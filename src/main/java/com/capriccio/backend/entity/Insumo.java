package com.capriccio.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "insumos")
@Data
public class Insumo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_insumo") // <--- Esto le dice a Java: "mira la columna con guion bajo"
    private Integer idInsumo;

    @Column(name = "nombre_insumo")
    private String nombreInsumo;

    @Column(name = "unidad_medida")
    private String unidadMedida;
    
    @Column(name = "costo_unitario", precision = 10, scale = 2)
    private BigDecimal costoUnitario;

    @Column(name = "stock_total_actual", precision = 10, scale = 2)
    private BigDecimal stockTotalActual;

    @Column(name = "stock_minimo_alerta", precision = 10, scale = 2)
    private BigDecimal stockMinimoAlerta;
}

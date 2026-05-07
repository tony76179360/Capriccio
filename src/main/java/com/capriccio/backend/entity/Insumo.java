package com.capriccio.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "insumos")

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

    public Integer getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Integer idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public BigDecimal getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(BigDecimal costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public BigDecimal getStockTotalActual() {
        return stockTotalActual;
    }

    public void setStockTotalActual(BigDecimal stockTotalActual) {
        this.stockTotalActual = stockTotalActual;
    }

    public BigDecimal getStockMinimoAlerta() {
        return stockMinimoAlerta;
    }

    public void setStockMinimoAlerta(BigDecimal stockMinimoAlerta) {
        this.stockMinimoAlerta = stockMinimoAlerta;
    }

    
    
    

}

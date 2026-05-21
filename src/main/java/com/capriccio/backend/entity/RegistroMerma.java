package com.capriccio.backend.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "registro_mermas")
public class RegistroMerma {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_merma")
private Integer idmerma;

@Column(name = "id_orden")
private Integer idorden;

@ManyToOne
@JoinColumn(name = "id_insumo", nullable = false)
private Insumo insumo;

@Column(name = "id_usuario")
private Integer idusuario;

@Column(name = "tipo_clasificacion")
private String tipoclasi;

@Column(name = "cantidad_perdida", precision = 10, scale=2)
private BigDecimal cantidadperdida;

@Column(name = "costo_financiero_calculado", precision = 10, scale =2)
private BigDecimal costofinancierocal;

@Column(name = "requiere_auditoria")
private Boolean requiereauditoria = false;

@Column(name = "fecha_registro", updatable = false)
private LocalDateTime fecharegistro= LocalDateTime.now();

@Column(name = "es_reutilizable")
    private Boolean esReutilizable = false;

    @Column(name = "desviacion_porcentaje", precision = 10, scale = 2)
    private BigDecimal desviacionPorcentaje;

    @Column(name = "estado_auditoria")
    private String estadoAuditoria = "Aceptado";

    public Integer getIdmerma() {
        return idmerma;
    }

    public void setIdmerma(Integer idmerma) {
        this.idmerma = idmerma;
    }

    public Integer getIdorden() {
        return idorden;
    }

    public void setIdorden(Integer idorden) {
        this.idorden = idorden;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getTipoclasi() {
        return tipoclasi;
    }

    public void setTipoclasi(String tipoclasi) {
        this.tipoclasi = tipoclasi;
    }

    public BigDecimal getCantidadperdida() {
        return cantidadperdida;
    }

    public void setCantidadperdida(BigDecimal cantidadperdida) {
        this.cantidadperdida = cantidadperdida;
    }

    public BigDecimal getCostofinancierocal() {
        return costofinancierocal;
    }

    public void setCostofinancierocal(BigDecimal costofinancierocal) {
        this.costofinancierocal = costofinancierocal;
    }

    public Boolean getRequiereauditoria() {
        return requiereauditoria;
    }

    public void setRequiereauditoria(Boolean requiereauditoria) {
        this.requiereauditoria = requiereauditoria;
    }

    public LocalDateTime getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(LocalDateTime fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Boolean getEsReutilizable() {
        return esReutilizable;
    }

    public void setEsReutilizable(Boolean esReutilizable) {
        this.esReutilizable = esReutilizable;
    }

    public BigDecimal getDesviacionPorcentaje() {
        return desviacionPorcentaje;
    }

    public void setDesviacionPorcentaje(BigDecimal desviacionPorcentaje) {
        this.desviacionPorcentaje = desviacionPorcentaje;
    }

    public String getEstadoAuditoria() {
        return estadoAuditoria;
    }

    public void setEstadoAuditoria(String estadoAuditoria) {
        this.estadoAuditoria = estadoAuditoria;
    }









}

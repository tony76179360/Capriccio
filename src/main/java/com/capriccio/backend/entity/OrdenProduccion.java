package com.capriccio.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ordenes_produccion") // Usamos minúsculas como en tu imagen
public class OrdenProduccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden")
    private Integer idOrden;

    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "cantidad_a_producir")
    private Integer cantidadAProducir;

    @Column(name = "estado")
    private String estado = "Pendiente";

    @Column(name = "fecha_solicitud", insertable = false, updatable = false)
    private LocalDateTime fechaSolicitud;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "cantidad_solicitada")
    private Integer cantidadSolicitada;

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getCantidadAProducir() {
        return cantidadAProducir;
    }

    public void setCantidadAProducir(Integer cantidadAProducir) {
        this.cantidadAProducir = cantidadAProducir;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(Integer cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    
}

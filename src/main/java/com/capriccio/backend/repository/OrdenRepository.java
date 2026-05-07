package com.capriccio.backend.repository;

import com.capriccio.backend.entity.OrdenProduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<OrdenProduccion, Integer> {
    List<OrdenProduccion> findByEstado(String estado);
}
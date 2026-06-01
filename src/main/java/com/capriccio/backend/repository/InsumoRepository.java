package com.capriccio.backend.repository;

import com.capriccio.backend.entity.Insumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Integer> {
    // Aquí Spring Boot da métodos como save(), findAll(), delete(), etc.
}
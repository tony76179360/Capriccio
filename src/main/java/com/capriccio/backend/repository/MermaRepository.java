package com.capriccio.backend.repository;

import com.capriccio.backend.entity.RegistroMerma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MermaRepository extends JpaRepository<RegistroMerma, Integer> {
}
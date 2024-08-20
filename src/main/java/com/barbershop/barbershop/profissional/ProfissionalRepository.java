package com.barbershop.barbershop.profissional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {
    List<Profissional> findByBarbeariaId(Integer barbeariaId);
}

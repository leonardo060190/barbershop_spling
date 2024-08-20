package com.barbershop.barbershop.profissionalServico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfissionalServicoRepository extends JpaRepository<ProfissionalServico, Integer> {
    List<ProfissionalServico> findByProfissionalId(Integer profissionalId);

}

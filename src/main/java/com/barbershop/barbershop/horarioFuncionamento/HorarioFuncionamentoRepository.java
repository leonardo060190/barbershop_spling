package com.barbershop.barbershop.horarioFuncionamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioFuncionamentoRepository extends JpaRepository<HorarioFuncionamento, Integer> {
    List<HorarioFuncionamento> findByBarbeariaId(Integer barbeariaId);

}

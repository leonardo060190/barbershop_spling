package com.barbershop.barbershop.agendamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
    List<Agendamento> findByServico_Barbearia_Id(Integer barbeariaId);

    List<Agendamento> findByClienteId(Integer clienteId);
}

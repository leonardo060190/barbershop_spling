package com.barbershop.barbershop.agendamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
@Query("SELECT a, ps, s, p FROM Agendamento a " +
        "JOIN FETCH a.profissionalServico ps " +
        "JOIN FETCH ps.servico s " +
        "JOIN FETCH ps.profissional p " +
        "WHERE s.barbearia.id = :barbeariaId")
List<Agendamento> findAgendamentosWithServiceAndProfessionalByBarbeariaId(@Param("barbeariaId") Integer barbeariaId);

@Query("SELECT a, ps, p FROM Agendamento a " +
            "JOIN FETCH a.profissionalServico ps " +
            "JOIN FETCH ps.servico s " +
            "JOIN FETCH ps.profissional p " +
            "WHERE ps.profissional.id = :proflissionalId")
List<Agendamento> findByProfissionalId(Integer proflissionalId);


List<Agendamento> findByClienteId(Integer clienteId);
}

package com.barbershop.barbershop.agendamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

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

@Query("SELECT a FROM Agendamento a WHERE a.profissionalServico.id = :profissionalId AND a.data = :data AND a.hora = :hora")
Optional<Agendamento> findExistingAgendamento(Integer profissionalId, LocalDate data, LocalTime hora);


List<Agendamento> findByClienteId(Integer clienteId);
}

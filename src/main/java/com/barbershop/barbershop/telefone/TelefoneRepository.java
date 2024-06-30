package com.barbershop.barbershop.telefone;

import com.barbershop.barbershop.agendamento.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {
    List<Telefone> findByClienteId(Integer clienteId);
}

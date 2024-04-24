package com.barbershop.barbershop.agendamentos;

import com.barbershop.barbershop.clientes.Cliente;
import com.barbershop.barbershop.servicos.Servico;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Enabled
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentosPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;
}

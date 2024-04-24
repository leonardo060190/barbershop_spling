package com.barbershop.barbershop.agendamento;

import com.barbershop.barbershop.cliente.Cliente;
import com.barbershop.barbershop.servico.Servico;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;

import java.io.Serializable;

@Enabled
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;
}

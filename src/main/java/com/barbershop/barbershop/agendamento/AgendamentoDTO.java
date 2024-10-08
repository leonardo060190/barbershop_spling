package com.barbershop.barbershop.agendamento;

import com.barbershop.barbershop.cliente.Cliente;
import com.barbershop.barbershop.profissionalServico.ProfissionalServico;
import com.barbershop.barbershop.servico.Servico;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class AgendamentoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;


    private Cliente cliente;


    private Servico servico;

    private ProfissionalServico profissionalServico;


    @NotNull(message = "O campo DATA é requerido")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDate data;

    @NotNull(message = "O campo HORA é requerido")
    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime hora;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    protected LocalDate dataCriacao = LocalDate.now();

    @Override
    public String toString() {
        return "AgendamentoDTO{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", servico=" + servico +
                ", profissionalServico=" + profissionalServico +
                ", data=" + data +
                ", hora=" + hora +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}

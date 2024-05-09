package com.barbershop.barbershop.horarioFuncionamento;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class HorarioFuncionamentoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotNull(message = "O campo INICIO é requerido")
    private LocalDate inicio;
    @NotNull(message = "O campo FIM é requerido")
    private LocalDate fim;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();

    private Integer barbeariaId;

    private Integer diaSemanaId;

    public HorarioFuncionamentoDTO(HorarioFuncionamento obj) {
        this.id = obj.getId();
        this.inicio = obj.getInicio();
        this.fim = obj.getFim();
        this.dataCriacao = obj.getDataCriacao();
        this.barbeariaId = obj.getBarbearia() != null ? obj.getBarbearia().getId() : null;
        this.diaSemanaId = obj.getDiaSemana() != null ? obj.getDiaSemana().getId() : null;

    }
}

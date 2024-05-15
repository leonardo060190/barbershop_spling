package com.barbershop.barbershop.diaSemana;

import com.barbershop.barbershop.horarioFuncionamento.HorarioFuncionamentoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class DiaSemanaDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotNull(message = "O campo Nome é requerido")
    private String nome;


    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCriacao = LocalDate.now();


    private List<HorarioFuncionamentoDTO> horarioFuncionamentos = new ArrayList<HorarioFuncionamentoDTO>();



    public DiaSemanaDTO(DiaSemana obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.dataCriacao = obj.getDataCriacao();
    }
}

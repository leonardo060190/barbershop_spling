package com.barbershop.barbershop.diaSemana;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;




@Getter
@Setter
public class DiaSemanaDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotNull(message = "O campo Nome é requerido")
    private String nome;


    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();


    public DiaSemanaDTO(DiaSemana obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.dataCriacao = obj.getDataCriacao();
    }
}

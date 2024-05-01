package com.barbershop.barbershop.estado;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
public class EstadoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    private Integer id;

    @NotNull(message = "O campo Nome é requerido")
    private String nome;

    @NotNull(message = "O campo SIGLA é requerido")
    private String sigla;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();



    public EstadoDTO(Estado obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.sigla = obj.getSigla();
        this.dataCriacao = obj.getDataCriacao();
    }
}


package com.barbershop.barbershop.servico;

import com.barbershop.barbershop.agendamento.Agendamento;
import com.barbershop.barbershop.barbearia.Barbearia;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class ServiceDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotNull(message = "O campo Nome é requerido")
    private String nome;

    @NotNull(message = "O campo PREÇO é requerido")
    private Double preco;

    @NotNull(message = "O campo DESCRIÇÃO é requerido")
    private String descricao;

    @NotNull(message = "O campo FOTO é requerido")
    private String foto;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();

    public ServiceDTO(Servico obj) {

        this.id = obj.getId();
        this.nome = obj.getNome();
        this.preco = obj.getPreco();
        this.descricao = obj.getDescricao();
        this.foto = obj.getFoto();
        this.dataCriacao = obj.getDataCriacao();
    }
}

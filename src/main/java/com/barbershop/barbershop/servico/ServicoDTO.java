package com.barbershop.barbershop.servico;

import com.barbershop.barbershop.agendamento.AgendamentoDTO;
import com.barbershop.barbershop.barbearia.Barbearia;
import com.barbershop.barbershop.profissionalServico.ProfissionalServico;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class ServicoDTO implements Serializable {
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

    private Barbearia barbearia;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCriacao = LocalDate.now();


    private List<AgendamentoDTO> agendamentos = new ArrayList<AgendamentoDTO>();

    private List<ProfissionalServico> profissionalServicos = new ArrayList<ProfissionalServico>();

    @Override
    public String toString() {
        return "ServicoDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", descricao='" + descricao + '\'' +
                ", foto='" + foto + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}

package com.barbershop.barbershop.barbearia;


import com.barbershop.barbershop.endereco.Endereco;
import com.barbershop.barbershop.horarioFuncionamento.HorarioFuncionamentoDTO;
import com.barbershop.barbershop.servico.ServicoDTO;
import com.barbershop.barbershop.telefone.TelefoneDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

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
public class BarbeariaDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotNull(message = "O campo Nome é requerido")
    private String nome;

    @NotNull(message = "O campo CNPJ é requerido")
    @CNPJ
    private String cnpj;

    @NotNull(message = "O campo E-MAIL é requerido")
    private String email;

    @NotNull(message = "O campo RAZÃO SOCIAL é requerido")
    private String razaoSocial;


    @NotNull(message = "O campo SENHA é requerido")
    private String senha;

    @NotNull(message = "O campo FOTO é requerido")
    private String foto;


    private Endereco endereco;

    @JsonFormat( pattern = "yyyy-MM-dd")
    private LocalDate dataCriacao = LocalDate.now();


    private List<ServicoDTO> servicos = new ArrayList<ServicoDTO>();


    private List<HorarioFuncionamentoDTO> horarioFuncionamentos = new ArrayList<HorarioFuncionamentoDTO>();


    private List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();



}

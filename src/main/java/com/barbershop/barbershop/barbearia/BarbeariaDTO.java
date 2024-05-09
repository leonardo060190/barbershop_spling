package com.barbershop.barbershop.barbearia;


import com.barbershop.barbershop.enuns.Perfil;
import com.barbershop.barbershop.horarioFuncionamento.HorarioFuncionamento;
import com.barbershop.barbershop.horarioFuncionamento.HorarioFuncionamentoDTO;
import com.barbershop.barbershop.servico.Servico;
import com.barbershop.barbershop.servico.ServicoDTO;
import com.barbershop.barbershop.telefone.Telefone;
import com.barbershop.barbershop.telefone.TelefoneDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
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

    private Integer enderecoId;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();

    private List<ServicoDTO> servicos = new ArrayList<>();

    private List<HorarioFuncionamentoDTO> horarioFuncionamentos = new ArrayList<>();

    private List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();


    public BarbeariaDTO(Barbearia obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cnpj = obj.getCnpj();
        this.email = obj.getEmail();
        this.razaoSocial = obj.getRazaoSocial();
        this.senha = obj.getSenha();
        this.dataCriacao = obj.getDataCriacao();
        this.enderecoId = obj.getEndereco() != null ? obj.getEndereco().getId() : null;

    }

}

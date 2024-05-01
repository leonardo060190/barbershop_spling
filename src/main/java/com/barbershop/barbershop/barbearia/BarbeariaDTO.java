package com.barbershop.barbershop.barbearia;

import com.barbershop.barbershop.endereco.Endereco;
import com.barbershop.barbershop.enuns.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class BarbeariaDTO implements Serializable {
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

    private Set<Integer> perfis = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public BarbeariaDTO(Barbearia obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cnpj = obj.getCnpj();
        this.email = obj.getEmail();
        this.razaoSocial = obj.getRazaoSocial();
        this.senha = obj.getSenha();
        this.dataCriacao = obj.getDataCriacao();
        this.perfis = obj.getPerfis().stream()
                .map(x -> x.getCodigo())
                .collect(Collectors.toSet());
        addPerfil(Perfil.BARBEARIA);

    }


    public BarbeariaDTO() {
        addPerfil(Perfil.BARBEARIA);
    }


    void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(perfil -> Perfil.toEnum(perfil)).collect(Collectors.toSet());
    }
}

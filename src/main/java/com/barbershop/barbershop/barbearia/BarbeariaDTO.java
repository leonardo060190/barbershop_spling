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


    private Integer barbearia_id;
    @NotNull(message = "O campo Nome é requerido")
    private String barbearia_nome;
    @NotNull(message = "O campo CNPJ é requerido")
    @CNPJ
    private String barbearia_cnpj;
    @NotNull(message = "O campo E-MAIL é requerido")
    private String barbearia_email;
    @NotNull(message = "O campo RAZÃO SOCIAL é requerido")
    private String barbearia_razaoSocial;
    @NotNull(message = "O campo SENHA é requerido")
    private String barbearia_senha;
    @NotNull(message = "O campo FOTO é requerido")
    private String barbearia_foto;

    private Set<Integer> perfis = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate barbearia_dataCriacao = LocalDate.now();

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public BarbeariaDTO(Barbearia obj){
        this.barbearia_id = obj.getBarbearia_id();
        this.barbearia_nome = obj.getBarbearia_nome();
        this.barbearia_cnpj = obj.getBarbearia_cnpj();
        this.barbearia_email = obj.getBarbearia_email();
        this.barbearia_razaoSocial = obj.getBarbearia_razaoSocial();
        this.barbearia_senha = obj.getBarbearia_senha();
        this.barbearia_dataCriacao = obj.getBarbearia_dataCriacao();
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

package com.barbershop.barbershop.barbearia;


import com.barbershop.barbershop.endereco.Endereco;
import com.barbershop.barbershop.enuns.Perfil;
import com.barbershop.barbershop.horarioFuncionamento.HorarioFuncionamento;
import com.barbershop.barbershop.servico.Servico;
import com.barbershop.barbershop.telefone.Telefone;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Entity
//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Barbearia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;


    private String nome;

    @Column(unique = true)
    private String cnpj;

    @Column(unique = true)
    private String email;


    private String razaoSocial;


    private String senha;


    private String foto;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS")
    private Set<Integer> perfis = new HashSet<>();


    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "barbearia", fetch = FetchType.LAZY)
    private List<Servico> servicos = new ArrayList<>();

    @OneToMany(mappedBy = "barbearia", fetch = FetchType.LAZY)
    private List<HorarioFuncionamento> horarioFuncionamentos = new ArrayList<>();


    @OneToMany(mappedBy = "barbearia", fetch = FetchType.LAZY)
    private List<Telefone> telefones = new ArrayList<>();


    public Barbearia() {
        addPerfil(Perfil.BARBEARIA);
    }


    void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(perfil -> Perfil.toEnum(perfil)).collect(Collectors.toSet());
    }

}


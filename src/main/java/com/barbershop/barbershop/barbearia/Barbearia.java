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

import java.util.HashSet;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Entity
//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "barbearia_id")
@Table(name = "barbearia")
public class Barbearia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "barbearia_id")
    private Integer barbearia_id;

    @Column(name = "barbearia_nome")
    private String barbearia_nome;

    @Column(unique = true, name = "barbearia_cnpj")
    private String barbearia_cnpj;

    @Column(unique = true, name = "barbearia_email")
    private String barbearia_email;

    @Column(name = "barbearia_razaoSocial")
    private String barbearia_razaoSocial;

    @Column(name = "barbearia_senha")
    private String barbearia_senha;

    @Column(name = "barbearia_foto")
    private String barbearia_foto;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS")
    private Set<Integer> perfis = new HashSet<>();

    @Column(name = "barbearia_dataCriacao")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate barbearia_dataCriacao = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "barbearia_endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "servico_id", fetch = FetchType.LAZY)
    private List<Servico> servicos;

    @OneToMany(mappedBy = "horarioFuncionamento_id", fetch = FetchType.LAZY)
    private List<HorarioFuncionamento> horarioFuncionamentos;


    @OneToMany(mappedBy = "telefone_id", fetch = FetchType.LAZY)
    private List<Telefone> telefones;


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


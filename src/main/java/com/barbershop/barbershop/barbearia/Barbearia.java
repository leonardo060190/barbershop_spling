package com.barbershop.barbershop.barbearia;


import com.barbershop.barbershop.endereco.Endereco;
import com.barbershop.barbershop.horarioFuncionamento.HorarioFuncionamento;
import com.barbershop.barbershop.servico.Servico;
import com.barbershop.barbershop.telefone.Telefone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import java.util.ArrayList;

import java.util.List;

@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Barbearia implements Serializable {
    @Serial
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

    @JsonIgnore
    private String senha;


    private String foto;



    private LocalDate dataCriacao = LocalDate.now();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "enderecoId", nullable = false)
    private Endereco endereco;

    @JsonIgnore
    @OneToMany(mappedBy = "barbearia", fetch = FetchType.EAGER)
    private List<Servico> servicos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "barbearia", fetch = FetchType.EAGER)
    private List<HorarioFuncionamento> horarioFuncionamentos = new ArrayList<HorarioFuncionamento>();

    @JsonIgnore
    @OneToMany(mappedBy = "barbearia", fetch = FetchType.EAGER)
    private List<Telefone> telefones = new ArrayList<Telefone>();

}


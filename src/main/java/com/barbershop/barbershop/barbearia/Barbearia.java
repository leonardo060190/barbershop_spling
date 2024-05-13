package com.barbershop.barbershop.barbearia;


import com.barbershop.barbershop.endereco.Endereco;
import com.barbershop.barbershop.enuns.Perfil;
import com.barbershop.barbershop.horarioFuncionamento.HorarioFuncionamento;
import com.barbershop.barbershop.servico.Servico;
import com.barbershop.barbershop.telefone.Telefone;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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


    private String senha;


    private String foto;



    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataCriacao = LocalDate.now();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "enderecoId")
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


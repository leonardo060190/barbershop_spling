package com.barbershop.barbershop.barbearia;


import com.barbershop.barbershop.agendamento.Agendamento;
import com.barbershop.barbershop.endereco.Endereco;
import com.barbershop.barbershop.horarioFuncionamento.HorarioFuncionamento;
import com.barbershop.barbershop.login.Login;
import com.barbershop.barbershop.servico.Servico;
import com.barbershop.barbershop.telefone.Telefone;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import java.util.ArrayList;

import java.util.List;

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

    @Column(length=50, nullable=false)
    private String nome;

    @Column(unique = true, length = 18, nullable = false)
    private String cnpj;

    @Column(length=200, nullable=false)
    private String razaoSocial;


    @Column(length=3000, nullable=false)
    private String foto;


    @Column(length=10, nullable=false)
    private LocalDate dataCriacao = LocalDate.now();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "enderecoId")
    @JsonBackReference("endereco_barbearias")
    private Endereco endereco;

    @OneToMany(mappedBy = "barbearia", fetch = FetchType.LAZY)
    @JsonManagedReference("barbearia_servicos")
    private List<Servico> servicos = new ArrayList<>();

    @OneToMany(mappedBy = "barbearia", fetch = FetchType.LAZY)
    @JsonManagedReference("barbearia_horarioFuncionamentos")
    private List<HorarioFuncionamento> horarioFuncionamentos = new ArrayList<HorarioFuncionamento>();


    @OneToMany(mappedBy = "barbearia", fetch = FetchType.LAZY)
    @JsonManagedReference("barbearia_telefones")
    private List<Telefone> telefones = new ArrayList<Telefone>();


    @OneToMany(mappedBy = "barbearia", fetch = FetchType.LAZY)
    @JsonManagedReference("barbearia_logins")
    private List<Login> logins = new ArrayList<Login>();

    @Override
    public String toString() {
        return "Barbearia{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", foto='" + foto + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}


package com.barbershop.barbershop.cliente;

import com.barbershop.barbershop.agendamento.Agendamento;
import com.barbershop.barbershop.endereco.Endereco;
import com.barbershop.barbershop.telefone.Telefone;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Cliente implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;


    private String nome;

    @Column(unique = true)
    @CPF
    private String cpf;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String senha;


    private LocalDate dataNascimento;


    private String foto;


    private LocalDate dataCriacao = LocalDate.now();


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "enderecoId", nullable = false)
    private Endereco endereco;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<Telefone> telefones = new ArrayList<Telefone>();

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<Agendamento> agendamentos = new ArrayList<Agendamento>();

}






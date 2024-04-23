package com.barbershop.barbershop.clientes;

import com.barbershop.barbershop.enuns.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Cliente implements Serializable{
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String email;
    private String senha;
    private String dataNascimento;
    private String foto;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS")
    private Set<Integer>perfis = new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();




    public Cliente(Integer id, String nome, String cpf, String email, String senha, String dataNascimento, String foto, LocalDate dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.foto = foto;
        this.dataCriacao = dataCriacao;
    }

    public Set<Perfil> getPerfis() { return perfis.stream().map(perfil -> Perfil.toEnum(perfil)).collect(Collectors.toSet()); }


}



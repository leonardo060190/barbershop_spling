package com.barbershop.barbershop.barbearias;

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
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
public class Barbearia implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nome;
    @Column(unique = true)
    private  String cnpj;
    @Column(unique = true)
    private String email;
    private String razaoSocial;
    private String senha;
    private String foto;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS")
    private Set<Integer>perfis =new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();


    public Barbearia(String id, String nome, String cnpj, String email, String razaoSocial, String senha, String foto, LocalDate dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.razaoSocial = razaoSocial;
        this.senha = senha;
        this.foto = foto;
        this.dataCriacao = dataCriacao;
    }

    public Set<Perfil> getPerfis() { return perfis.stream().map(perfil -> Perfil.toEnum(perfil)).collect(Collectors.toSet()); }

}

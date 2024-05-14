package com.barbershop.barbershop.estado;

import com.barbershop.barbershop.cidade.Cidade;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Estado implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String sigla;


    private LocalDate dataCriacao = LocalDate.now();

    @JsonIgnore
    @OneToMany(mappedBy = "estado", fetch = FetchType.EAGER)
    private List<Cidade> cidades = new ArrayList<Cidade>();

    public Estado(Integer id, String nome, String sigla, LocalDate now) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.dataCriacao = LocalDate.now();
    }

}

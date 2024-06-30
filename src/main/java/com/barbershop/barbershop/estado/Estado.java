package com.barbershop.barbershop.estado;

import com.barbershop.barbershop.cidade.Cidade;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(length=20, nullable=false)
    private String nome;

    @Column(length=2, nullable=false)
    private String sigla;

    @Column(length=10, nullable=false)
    private LocalDate dataCriacao = LocalDate.now();

    @OneToMany(mappedBy = "estado", fetch = FetchType.EAGER)
    @JsonManagedReference("estado_cidades")
    private List<Cidade> cidades = new ArrayList<Cidade>();

    public Estado(Integer id, String nome, String sigla, LocalDate now) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.dataCriacao = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}

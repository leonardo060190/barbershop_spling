package com.barbershop.barbershop.cidade;

import com.barbershop.barbershop.endereco.Endereco;
import com.barbershop.barbershop.estado.Estado;
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
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cidade implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(length=50, nullable=false)
    private String nome;

    @Column(length=10, nullable=false)
    protected LocalDate dataCriacao = LocalDate.now();


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estadoId", nullable = false)
    private Estado estado;

    @JsonIgnore
    @OneToMany(mappedBy = "cidade", fetch = FetchType.EAGER)
    private List<Endereco> enderecos = new ArrayList<Endereco>();

    public Cidade(Integer id, String nome, Estado estado, LocalDate now) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.dataCriacao = LocalDate.now();
    }
}

package com.barbershop.barbershop.cidade;

import com.barbershop.barbershop.endereco.Endereco;
import com.barbershop.barbershop.estado.Estado;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

public class Cidade implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(length=50, nullable=false)
    private String nome;

    protected LocalDate dataCriacao = LocalDate.now();


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estadoId", nullable = false)
    @JsonBackReference("estado_cidades")
    private Estado estado;

    @OneToMany(mappedBy = "cidade", fetch = FetchType.EAGER)
    @JsonManagedReference("cidade_enderecos")
    private List<Endereco> enderecos = new ArrayList<Endereco>();

    public Cidade(Integer id, String nome, Estado estado, LocalDate now) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.dataCriacao = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}

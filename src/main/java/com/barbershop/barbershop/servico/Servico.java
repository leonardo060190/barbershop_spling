package com.barbershop.barbershop.servico;

import com.barbershop.barbershop.agendamento.Agendamento;
import com.barbershop.barbershop.barbearia.Barbearia;
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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Servico implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length=100, nullable=false)
    private String nome;

    @Column(length=10, nullable=false)
    private Double preco;

    @Column(length=3000, nullable=false)
    private String descricao;

    @Column(length=3000, nullable=false)
    private String foto;

    @Column(length=10, nullable=false)
    private LocalDate dataCriacao = LocalDate.now();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "barbeariaId", nullable = false)
    private Barbearia barbearia;

    @JsonIgnore
    @OneToMany(mappedBy = "servico", fetch = FetchType.EAGER)
    private List<Agendamento> agendamentos = new ArrayList<Agendamento>();

}

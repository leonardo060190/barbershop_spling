package com.barbershop.barbershop.diaSemana;

import com.barbershop.barbershop.horarioFuncionamento.HorarioFuncionamento;
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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class DiaSemana implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length=20, nullable=false)
    private String nome;

    @Column(length=10, nullable=false)
    protected LocalDate dataCriacao = LocalDate.now();


    @OneToMany(mappedBy = "diaSemana", fetch = FetchType.EAGER)
    @JsonManagedReference("diaSemana_horarioFuncionamentos")
    private List<HorarioFuncionamento> horarioFuncionamentos = new ArrayList<HorarioFuncionamento>();



    public DiaSemana( String nome, LocalDate now) {
        this.nome = nome;
        this.dataCriacao = LocalDate.now();
    }

    @Override
    public String toString() {
        return "DiaSemana{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}

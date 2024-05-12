package com.barbershop.barbershop.diaSemana;

import com.barbershop.barbershop.horarioFuncionamento.HorarioFuncionamento;
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


    private String nome;


    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    @JsonIgnore
    @OneToMany(mappedBy = "diaSemana", fetch = FetchType.LAZY)
    private List<HorarioFuncionamento> horarioFuncionamento = new ArrayList<HorarioFuncionamento>();



    public DiaSemana( String nome, LocalDate now) {
        this.nome = nome;
        this.dataCriacao = LocalDate.now();
    }
}

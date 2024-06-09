package com.barbershop.barbershop.horarioFuncionamento;

import com.barbershop.barbershop.barbearia.Barbearia;
import com.barbershop.barbershop.diaSemana.DiaSemana;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;


@ToString
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class HorarioFuncionamento implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    @Column(length=6)
    private LocalTime inicio;

    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    @Column(length=6)
    private LocalTime fim;

    @Column(length=10, nullable=false)
    protected LocalDate dataCriacao = LocalDate.now();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "barbeariaId", nullable = false)
    private Barbearia barbearia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "diaSemanaId", nullable = false)
    private DiaSemana diaSemana;

}

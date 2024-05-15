package com.barbershop.barbershop.horarioFuncionamento;

import com.barbershop.barbershop.barbearia.Barbearia;
import com.barbershop.barbershop.diaSemana.DiaSemana;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

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

    private LocalDate inicio;

    private LocalDate fim;

    protected LocalDate dataCriacao = LocalDate.now();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "barbeariaId", nullable = false)
    private Barbearia barbearia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "diaSemanaId", nullable = false)
    private DiaSemana diaSemana;
}

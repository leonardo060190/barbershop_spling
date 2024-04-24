package com.barbershop.barbershop.horarioFuncionamento;

import com.barbershop.barbershop.barbearia.Barbearia;
import com.barbershop.barbershop.diaSemana.DiaSemana;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class HorarioFuncionamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate inicio;
    private LocalDate fim;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();
    @ManyToOne
    @JoinColumn(name = "barbearia_id")
    private Barbearia barbearia;
    @ManyToOne
    @JoinColumn(name = "diaSemana_id")
    private DiaSemana diaSemana;
}

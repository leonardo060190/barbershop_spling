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
@EqualsAndHashCode(of = "horarioFuncionamento_id")
public class HorarioFuncionamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "horarioFuncionamento_id")
    private Integer horarioFuncionamento_id;
    @Column(name = "horarioFuncionamento_inicio")
    private LocalDate horarioFuncionamento_inicio;
    @Column(name = "horarioFuncionamento_fim")
    private LocalDate horarioFuncionamento_fim;
    @Column(name = "horarioFuncionamento_dataCriacao")
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate horarioFuncionamento_dataCriacao = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "horarioFuncionamento_barbearia_id")
    private Barbearia barbearia;

    @ManyToOne
    @JoinColumn(name = "horarioFuncionamento_diaSemana_id")
    private DiaSemana diaSemana;
}

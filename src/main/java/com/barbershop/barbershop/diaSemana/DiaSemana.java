package com.barbershop.barbershop.diaSemana;

import com.barbershop.barbershop.horarioFuncionamento.HorarioFuncionamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "diasemana_id")
@Table(name = "diasemana")
public class DiaSemana implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diasemana_id")
    private Integer diasemana_id;

    @Column(name = "diasemana_nome")
    private String diasemana_nome;

    @Column(name = "diasemana_datacriacao")
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate diasemana_dataCriacao = LocalDate.now();

    @OneToMany(mappedBy = "horarioFuncionamento_id", fetch = FetchType.LAZY)
    private List<HorarioFuncionamento> horarioFuncionamento;

    public DiaSemana(Object o, String s, LocalDate now) {
    }
}

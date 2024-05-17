package com.barbershop.barbershop.agendamento;

import com.barbershop.barbershop.cliente.Cliente;
import com.barbershop.barbershop.servico.Servico;
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

public class Agendamento implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Temporal(TemporalType.DATE)
    @Column(length=10, nullable=false)
    private LocalDate data;


    @Temporal(TemporalType.TIME)
    @Column(length=6, nullable=false)
    private LocalTime hora;

    @Column(length=10, nullable=false)
    protected LocalDate dataCriacao = LocalDate.now();


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clienteId", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "servicoId", nullable = false)
    private Servico servico;

}

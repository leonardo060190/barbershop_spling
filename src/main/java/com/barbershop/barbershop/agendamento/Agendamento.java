package com.barbershop.barbershop.agendamento;

import com.barbershop.barbershop.cliente.Cliente;
import com.barbershop.barbershop.servico.Servico;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "agendamento_id")
@Table(name = "agendamento")
public class Agendamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agendamento_id")
    private Integer agendamento_id;


    @Column(name = "agendamento_data")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private LocalDate agendamento_data;

    @Column(name = "agendamento_hora")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime agendamento_hora;

    @Column(name = "agendamento_dataCriacao")
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate agendamento_dataCriacao = LocalDate.now();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agendamento_cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agendamento_servico_id")
    private Servico servico;

}

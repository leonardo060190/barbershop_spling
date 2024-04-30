package com.barbershop.barbershop.agendamento;

import com.barbershop.barbershop.cliente.Cliente;
import com.barbershop.barbershop.servico.Servico;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "agendamento_id")
@Table(name = "agendamento")
public class Agendamento implements Serializable {
    private static final long serialVersionUID = 1L;

//    @JsonIgnore
//    @EmbeddedId
//    @Column(name = "agendamento_id")
//    private AgendamentoPK agendamento_id = new AgendamentoPK();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agendamento_id")
    private Integer agendamento_id;


    @Column(name = "agendamento_data")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate agendamento_data;

    @Column(name = "agendamento_dataCriacao")
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate agendamento_dataCriacao = LocalDate.now();


    @ManyToMany
    @JoinColumn(name = "agendamento_cliente_id")
    private Cliente cliente;

    @ManyToMany
    @JoinColumn(name = "agendamento_servico_id")
    private Servico servico;

}

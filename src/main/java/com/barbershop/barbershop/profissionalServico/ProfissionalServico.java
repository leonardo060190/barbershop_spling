package com.barbershop.barbershop.profissionalServico;

import com.barbershop.barbershop.agendamento.Agendamento;
import com.barbershop.barbershop.profissional.Profissional;
import com.barbershop.barbershop.servico.Servico;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class ProfissionalServico implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "servicoId")
    @JsonBackReference("servico_profissionalServico")
    private Servico servico;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profissionalId")
    @JsonBackReference("profissional_profissionalServico")
    private Profissional profissional;

    @OneToMany(mappedBy = "profissionalServico", fetch = FetchType.EAGER)
    @JsonManagedReference("profissionalServico_agendamentos")
    private List<Agendamento> agendamentos = new ArrayList<Agendamento>();

    @Override
    public String toString() {
        return "ProfissionalServico{" +
                "id=" + id +
                ", servico=" + servico +
                ", profissional=" + profissional +
                ", agendamentos=" + agendamentos +
                '}';
    }
}

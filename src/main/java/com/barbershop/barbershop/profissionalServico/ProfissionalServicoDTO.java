package com.barbershop.barbershop.profissionalServico;

import com.barbershop.barbershop.agendamento.Agendamento;
import com.barbershop.barbershop.profissional.Profissional;
import com.barbershop.barbershop.servico.Servico;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class ProfissionalServicoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private Servico servico;


    private Profissional profissional;


    private List<Agendamento> agendamentos = new ArrayList<Agendamento>();


    @Override
    public String toString() {
        return "ProfissionalServicoDTO{" +
                "id=" + id +
                ", servico=" + servico +
                ", profissional=" + profissional +
                '}';
    }
}

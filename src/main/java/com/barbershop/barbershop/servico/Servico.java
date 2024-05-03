package com.barbershop.barbershop.servico;

import com.barbershop.barbershop.agendamento.Agendamento;
//import com.barbershop.barbershop.agendamento.AgendamentoPK;
import com.barbershop.barbershop.barbearia.Barbearia;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Servico implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Double preco;

    private String descricao;

    private String foto;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "barbearia_id")
    private Barbearia barbearia;

    @JsonIgnore
    @OneToMany(mappedBy = "servico", fetch = FetchType.LAZY)
    private List<Agendamento> agendamentos = new ArrayList<>();

}

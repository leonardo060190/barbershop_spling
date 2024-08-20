package com.barbershop.barbershop.servico;

import com.barbershop.barbershop.agendamento.Agendamento;
import com.barbershop.barbershop.barbearia.Barbearia;
import com.barbershop.barbershop.profissionalServico.ProfissionalServico;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(length=100, nullable=false)
    private String nome;

    @Column(length=10, nullable=false)
    private Double preco;

    @Column(length=3000, nullable=false)
    private String descricao;

    @Column(length=3000, nullable=false)
    private String foto;

    @Column(length=10, nullable=false)
    private LocalDate dataCriacao = LocalDate.now();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "barbeariaId")
    @JsonBackReference("barbearia_servicos")
    private Barbearia barbearia;

    @OneToMany(mappedBy = "servico", fetch = FetchType.EAGER)
    @JsonManagedReference("servico_agendamentos")
    private List<Agendamento> agendamentos = new ArrayList<Agendamento>();

    @OneToMany(mappedBy = "servico", fetch = FetchType.EAGER)
    @JsonManagedReference("servico_profissionalServico")
    private List<ProfissionalServico> profissionalServicos = new ArrayList<ProfissionalServico>();

    @Override
    public String toString() {
        return "Servico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", descricao='" + descricao + '\'' +
                ", foto='" + foto + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}

package com.barbershop.barbershop.servico;

import com.barbershop.barbershop.agendamento.Agendamento;
//import com.barbershop.barbershop.agendamento.AgendamentoPK;
import com.barbershop.barbershop.barbearia.Barbearia;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Servico implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String nome;

    private Double preco;

    private String descricao;

    private String foto;

    @ManyToOne
    @JoinColumn(name = "barbearia_id")
    private Barbearia barbearia;

    @OneToMany(mappedBy = "servico", fetch = FetchType.LAZY)
    private List<Agendamento> agendamentos;

}

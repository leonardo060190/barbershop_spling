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
@EqualsAndHashCode(of = "servico_id")
@Table(name = "servico")
public class Servico implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "servico_id")
    private Integer servico_id;
    @Column(name = "servico_nome")
    private String servico_nome;
    @Column(name = "servico_preco")
    private Double servico_preco;
    @Column(name = "servico_descricao")
    private String servico_descricao;
    @Column(name = "servico_foto")
    private String servico_foto;
    @ManyToOne
    @JoinColumn(name = "servico_barbearia_id")
    private Barbearia barbearia;

    @OneToMany(mappedBy = "agendamento_id", fetch = FetchType.LAZY)
    private List<Agendamento> agendamentos;

}

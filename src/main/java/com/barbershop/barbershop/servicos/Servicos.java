package com.barbershop.barbershop.servicos;

import com.barbershop.barbershop.barbearias.Barbearia;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Servicos implements Serializable {
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

}

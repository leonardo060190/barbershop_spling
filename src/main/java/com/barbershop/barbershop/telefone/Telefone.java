package com.barbershop.barbershop.telefone;

import com.barbershop.barbershop.barbearia.Barbearia;
import com.barbershop.barbershop.cliente.Cliente;
import jakarta.persistence.*;
import lombok.*;


import java.io.Serial;
import java.io.Serializable;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Telefone implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String numero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "barbeariaId")
    private Barbearia barbearia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clienteId")
    private Cliente cliente;
}
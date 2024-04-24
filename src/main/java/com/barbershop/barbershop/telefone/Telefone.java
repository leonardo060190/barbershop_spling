package com.barbershop.barbershop.telefone;

import com.barbershop.barbershop.barbearia.Barbearia;
import com.barbershop.barbershop.cliente.Cliente;
import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Telefone implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String telefone;
    @ManyToOne
    @JoinColumn(name = "barbearia_id")
    private Barbearia barbearia;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}

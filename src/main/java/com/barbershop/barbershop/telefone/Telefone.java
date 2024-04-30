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
@EqualsAndHashCode(of = "telefone_id")
@Table(name = "telefone")
public class Telefone implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "telefone_id")
    private Integer telefone_id;

    @Column(name = "telefone_numero", unique = true)
    private String telefone_numero;
    @ManyToOne
    @JoinColumn(name = "telefone_barbearia_id")
    private Barbearia barbearia;
    @ManyToOne
    @JoinColumn(name = "telefone_cliente_id")
    private Cliente cliente;
}

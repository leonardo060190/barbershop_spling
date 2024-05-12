package com.barbershop.barbershop.telefone;


import com.barbershop.barbershop.barbearia.Barbearia;
import com.barbershop.barbershop.cliente.Cliente;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class TelefoneDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    private Integer id;

    private String numero;

    private Integer barbeariaId;

    private Integer clienteId;

    public TelefoneDTO(Telefone obj) {
        this.id = obj.getId();
        this.numero = obj.getNumero();
        this.barbeariaId = obj.getBarbearia().getId();
        this.clienteId = obj.getCliente().getId();
    }
}

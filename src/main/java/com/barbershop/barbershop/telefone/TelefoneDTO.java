package com.barbershop.barbershop.telefone;


import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@Getter
@Setter
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
        this.barbeariaId = obj.getBarbearia() != null ? obj.getBarbearia().getId() : null;
        this.clienteId = obj.getCliente() != null ? obj.getCliente().getId() : null;
    }
}

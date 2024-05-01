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

    public TelefoneDTO(Telefone obj) {
        this.id = obj.getId();
        this.numero = obj.getNumero();
    }
}

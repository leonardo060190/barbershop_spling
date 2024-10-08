package com.barbershop.barbershop.telefone;


import com.barbershop.barbershop.barbearia.Barbearia;
import com.barbershop.barbershop.cliente.Cliente;
import com.barbershop.barbershop.profissional.Profissional;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

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

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCriacao = LocalDate.now();

    private Barbearia barbearia;

    private Cliente cliente;

    private Profissional profissional;


    @Override
    public String toString() {
        return "TelefoneDTO{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}

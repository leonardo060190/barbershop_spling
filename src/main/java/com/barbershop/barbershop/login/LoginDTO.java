package com.barbershop.barbershop.login;

import com.barbershop.barbershop.barbearia.Barbearia;
import com.barbershop.barbershop.cliente.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class LoginDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    private Integer id;

    @NotNull(message = "O campo E-mail é requerido")
    private String email;

    @NotNull(message = "O campo Senha é requerido")
    private String senha;


    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCriacao = LocalDate.now();


    private Barbearia barbearia;

    private Cliente cliente;

    @Override
    public String toString() {
        return "LoginDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}

package com.barbershop.barbershop.login;

import com.barbershop.barbershop.barbearia.Barbearia;
import com.barbershop.barbershop.cliente.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class LoginGetDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;


    private Integer id;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private String senha;


    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCriacao = LocalDate.now();


    private Barbearia barbearia;

    private Cliente cliente;
}

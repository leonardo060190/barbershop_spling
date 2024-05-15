package com.barbershop.barbershop.horarioFuncionamento;


import com.barbershop.barbershop.barbearia.Barbearia;
import com.barbershop.barbershop.diaSemana.DiaSemana;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class HorarioFuncionamentoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotNull(message = "O campo INICIO é requerido")
    private LocalDate inicio;

    @NotNull(message = "O campo FIM é requerido")
    private LocalDate fim;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCriacao = LocalDate.now();


    private Barbearia barbearia;


    private DiaSemana diaSemana;

}

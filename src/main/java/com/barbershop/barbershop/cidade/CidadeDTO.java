package com.barbershop.barbershop.cidade;


import com.barbershop.barbershop.endereco.EnderecoDTO;
import com.barbershop.barbershop.estado.Estado;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class CidadeDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotNull(message = "O campo Nome é requerido")
    private String nome;


    private Estado estado;

    @JsonFormat(pattern = "yyyy-MM-dd")
    protected LocalDate dataCriacao = LocalDate.now();

    @JsonIgnore
    private List<EnderecoDTO> enderecos = new ArrayList<EnderecoDTO>();

}

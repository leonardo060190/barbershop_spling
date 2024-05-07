package com.barbershop.barbershop.estado;



import com.barbershop.barbershop.cidade.CidadeDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    private Integer id;

    @NotNull(message = "O campo NOME é requerido")
    private String nome;

    @NotNull(message = "O campo SIGLA é requerido")
    private String sigla;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();

    private List<CidadeDTO> cidades = new ArrayList<CidadeDTO>();


    public EstadoDTO(Estado obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.sigla = obj.getSigla();
        this.dataCriacao = obj.getDataCriacao();

    }
}


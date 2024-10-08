package com.barbershop.barbershop.estado;



import com.barbershop.barbershop.cidade.CidadeDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

public class EstadoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    private Integer id;

    @NotNull(message = "O campo NOME é requerido")
    private String nome;

    @NotNull(message = "O campo SIGLA é requerido")
    private String sigla;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCriacao = LocalDate.now();


    private List<CidadeDTO> cidades= new ArrayList<CidadeDTO>();


    public EstadoDTO(Estado obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.sigla = obj.getSigla();
        this.dataCriacao = obj.getDataCriacao();

    }

    @Override
    public String toString() {
        return "EstadoDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}


package com.barbershop.barbershop.endereco;



import com.barbershop.barbershop.barbearia.BarbeariaDTO;
import com.barbershop.barbershop.cidade.Cidade;
import com.barbershop.barbershop.cliente.ClienteDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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

public class EnderecoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @NotNull(message = "O campo RUA é requerido")
    private String rua;

    @NotNull(message = "O campo BAIRRO é requerido")
    private String bairro;

    @NotNull(message = "O campo NUMERO é requerido")
    private Integer numero;

    @NotNull(message = "O campo CEP é requerido")
    private String cep;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCriacao = LocalDate.now();


    private Cidade cidade;


    private List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();



    private List<BarbeariaDTO> barbearias = new ArrayList<BarbeariaDTO>();


    @Override
    public String toString() {
        return "EnderecoDTO{" +
                "id=" + id +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", numero=" + numero +
                ", cep='" + cep + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
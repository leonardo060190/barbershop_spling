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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataCriacao = LocalDate.now();

    private Integer cidadeId;

    @JsonIgnore
    private List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();

    @JsonIgnore
    private List<BarbeariaDTO> barbearias = new ArrayList<BarbeariaDTO>();



    public EnderecoDTO(Endereco obj) {
        this.id = obj.getId();
        this.rua = obj.getRua();
        this.bairro = obj.getBairro();
        this.numero = obj.getNumero();
        this.cep = obj.getCep();
        this.dataCriacao = obj.getDataCriacao();
        this.cidadeId = obj.getCidade().getId();
    }

}
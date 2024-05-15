package com.barbershop.barbershop.endereco;

import com.barbershop.barbershop.barbearia.Barbearia;
import com.barbershop.barbershop.cidade.Cidade;
import com.barbershop.barbershop.cliente.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ToString
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Endereco implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String rua;

    private String bairro;

    private Integer numero;

    private String cep;

    protected LocalDate dataCriacao = LocalDate.now();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cidadeId", nullable = false)
    private Cidade cidade;

    @JsonIgnore
    @OneToMany(mappedBy = "endereco", fetch = FetchType.EAGER)
    private List<Cliente> clientes = new ArrayList<Cliente>();

    @JsonIgnore
    @OneToMany(mappedBy = "endereco", fetch = FetchType.EAGER)
    private List<Barbearia> barbearias = new ArrayList<Barbearia>();

}

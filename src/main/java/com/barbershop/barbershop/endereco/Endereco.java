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

    @Column(length=250, nullable=false)
    private String rua;

    @Column(length=100, nullable=false)
    private String bairro;

    @Column(length=10, nullable=false)
    private Integer numero;

    @Column(length=10, nullable=false)
    private String cep;

    @Column(length=10, nullable=false)
    protected LocalDate dataCriacao = LocalDate.now();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cidadeId")
    private Cidade cidade;

    @JsonIgnore
    @OneToMany(mappedBy = "endereco", fetch = FetchType.EAGER)
    private List<Cliente> clientes = new ArrayList<Cliente>();

    @JsonIgnore
    @OneToMany(mappedBy = "endereco", fetch = FetchType.EAGER)
    private List<Barbearia> barbearias = new ArrayList<Barbearia>();

}

package com.barbershop.barbershop.endereco;

import com.barbershop.barbershop.barbearia.Barbearia;
import com.barbershop.barbershop.cidade.Cidade;
import com.barbershop.barbershop.cliente.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "endereco_id")
@Table(name = "endereco")
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id")
    private Integer endereco_id;
    @Column(name = "endereco_rua")
    private String endereco_rua;
    @Column(name = "endereco_bairro")
    private String endereco_bairro;
    @Column(name = "endereco_numero")
    private Integer endereco_numero;
    @Column(name = "endereco_cep")
    private String endereco_cep;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "endereco_cidade_id")
    private Cidade cidade;

    @OneToMany(mappedBy = "cliente_id", fetch = FetchType.LAZY)
    private List<Cliente> clientes;

    @OneToMany(mappedBy = "barbearia_id", fetch = FetchType.LAZY)
    private List<Barbearia> barbearias;
}

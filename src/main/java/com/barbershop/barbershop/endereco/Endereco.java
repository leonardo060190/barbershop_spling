package com.barbershop.barbershop.endereco;

import com.barbershop.barbershop.barbearia.Barbearia;
import com.barbershop.barbershop.cidade.Cidade;
import com.barbershop.barbershop.cliente.Cliente;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @JsonBackReference("cidade_enderecos")
    private Cidade cidade;

    @OneToMany(mappedBy = "endereco", fetch = FetchType.EAGER)
    @JsonManagedReference("endereco_clientes")
    private List<Cliente> clientes = new ArrayList<Cliente>();

    @OneToMany(mappedBy = "endereco", fetch = FetchType.EAGER)
    @JsonManagedReference("endereco_barbearias")
    private List<Barbearia> barbearias = new ArrayList<Barbearia>();

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", numero=" + numero +
                ", cep='" + cep + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}

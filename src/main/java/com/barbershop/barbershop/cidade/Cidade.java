package com.barbershop.barbershop.cidade;

import com.barbershop.barbershop.endereco.Endereco;
import com.barbershop.barbershop.estado.Estado;
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
public class Cidade implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String nome;

    protected LocalDate dataCriacao = LocalDate.now();


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estadoId", nullable = false)
    private Estado estado;

    @JsonIgnore
    @OneToMany(mappedBy = "cidade", fetch = FetchType.EAGER)
    private List<Endereco> enderecos = new ArrayList<Endereco>();

}

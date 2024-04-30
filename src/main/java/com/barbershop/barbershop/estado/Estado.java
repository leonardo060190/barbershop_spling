package com.barbershop.barbershop.estado;

import com.barbershop.barbershop.cidade.Cidade;
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
@EqualsAndHashCode(of = "estado_id")
@Table(name = "estado")
public class Estado implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estado_id")
    private Integer estado_id;
    @Column(name = "estado_nome")
    private String estado_nome;
    @Column(name = "estado_sigla")
    private String estado_sigla;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "estado_dataCriacao")
    protected LocalDate dataCriacao = LocalDate.now();

    @OneToMany(mappedBy = "cidade_id", fetch = FetchType.LAZY)
    private List<Cidade> cidades;

}

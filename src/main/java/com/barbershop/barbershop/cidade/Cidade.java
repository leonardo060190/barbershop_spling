package com.barbershop.barbershop.cidade;

import com.barbershop.barbershop.estado.Estado;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "cidade_id")
@Table(name = "cidade")
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cidade_id")
    private Integer cidade_id;
    @Column(name = "cidade_nome")
    private String cidade_nome;
    @Column(name = "cidade_dataCriacao")
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate cidade_dataCriacao = LocalDate.now();
    @ManyToOne
    @JoinColumn(name = "cidade_estado_id")
    private Estado estado;
}

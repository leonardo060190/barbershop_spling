package com.barbershop.barbershop.cliente;

import com.barbershop.barbershop.agendamento.Agendamento;
//import com.barbershop.barbershop.agendamento.AgendamentoPK;
import com.barbershop.barbershop.endereco.Endereco;
import com.barbershop.barbershop.enuns.Perfil;
import com.barbershop.barbershop.telefone.Telefone;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "cliente_id")
@Table(name = "cliente")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Integer cliente_id;

    @Column(name = "cliente_nome")
    private String cliente_nome;

    @Column(unique = true, name = "cliente_cpf")
    @CPF
    private String cliente_cpf;

    @Column(unique = true, name = "cliente_email")
    private String cliente_email;

    @Column(name = "cliente_senha")
    private String cliente_senha;

    @Column(name = "cliente_datanascimento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate cliente_dataNascimento;

    @Column(name = "cliente_foto")
    private String cliente_foto;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS")
    private Set<Integer> perfis = new HashSet<>();

    @Column(name = "cliente_datacriacao")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate cliente_dataCriacao = LocalDate.now();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_endereco_id", nullable = false)
    private Endereco endereco;

    @OneToMany(mappedBy = "telefone_id", fetch = FetchType.LAZY)
    private List<Telefone> telefones;

    @ManyToMany(mappedBy = "agendamento_id", fetch = FetchType.LAZY)
    private List<Agendamento> agendamentos;


    public Cliente() {
        addPerfil(Perfil.CLIENTE);
    }

    private void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }


    public Set<Perfil> getPerfis() {
        return perfis.stream().map(perfil -> Perfil.toEnum(perfil)).collect(Collectors.toSet());
    }

}






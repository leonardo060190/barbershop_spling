package com.barbershop.barbershop.cliente;

import com.barbershop.barbershop.agendamento.Agendamento;
import com.barbershop.barbershop.endereco.Endereco;
import com.barbershop.barbershop.enuns.Perfil;
import com.barbershop.barbershop.login.Login;
import com.barbershop.barbershop.telefone.Telefone;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Cliente implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length=50, nullable=false)
    private String nome;

    @Column(length=50, nullable=false)
    private String sobreNome;

    @Column(length = 14, unique = true)
    @CPF
    private String cpf;

    @Column(length = 10, nullable = false)
    private LocalDate dataNascimento;

    @Column(length=3000, nullable=false)
    private String foto;

    @Column(length=10, nullable=false)
    private LocalDate dataCriacao = LocalDate.now();

    @Enumerated(EnumType.STRING)
    private Perfil perfil;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "enderecoId")
    @JsonBackReference("endereco_clientes")
    private Endereco endereco;


    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    @JsonManagedReference("cliente_telefones")
    private List<Telefone> telefones = new ArrayList<Telefone>();

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    @JsonManagedReference("cliente_agendamentos")
    private List<Agendamento> agendamentos = new ArrayList<Agendamento>();

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    @JsonManagedReference("cliente_logins")
    private List<Login> logins = new ArrayList<Login>();

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", foto='" + foto + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}






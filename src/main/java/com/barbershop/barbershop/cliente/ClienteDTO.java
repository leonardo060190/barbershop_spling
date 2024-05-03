package com.barbershop.barbershop.cliente;

import com.barbershop.barbershop.agendamento.Agendamento;
import com.barbershop.barbershop.agendamento.AgendamentoDTO;
import com.barbershop.barbershop.enuns.Perfil;
import com.barbershop.barbershop.telefone.Telefone;
import com.barbershop.barbershop.telefone.TelefoneDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Getter
@Setter
public class ClienteDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1l;

    private Integer id;

    @NotNull(message = "O campo Nome é requerido")
    private String nome;

    @NotNull(message = "O campo CPF é requerido")
    @CPF
    private String cpf;

    @Email
    @NotNull(message = "O campo E-MAIL é requerido")
    private String email;

    @NotNull(message = "O campo SENHA é requerido")
    private String senha;

    @NotNull(message = "O campo DATANASCIMENTO é requerido")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotNull(message = "O campo FOTO é requerido")
    private String foto;

    private Set<Integer> perfis = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();

    private List<TelefoneDTO> telefones = new ArrayList<>();

    private List<AgendamentoDTO> agendamentos = new ArrayList<>();


    public ClienteDTO(Cliente obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.dataNascimento = obj.getDataNascimento();
        this.foto = obj.getFoto();
        this.perfis = obj.getPerfis().stream()
                .map(x -> x.getCodigo())
                .collect(Collectors.toSet());;
        this.dataCriacao = obj.getDataCriacao();
    }

    public ClienteDTO() {
        addPerfil(Perfil.CLIENTE);
    }

    private void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }


    public Set<Perfil> getPerfis() {
        return perfis.stream().map(perfil -> Perfil.toEnum(perfil)).collect(Collectors.toSet());
    }

}

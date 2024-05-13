package com.barbershop.barbershop.cliente;


import com.barbershop.barbershop.agendamento.AgendamentoDTO;
import com.barbershop.barbershop.endereco.Endereco;
import com.barbershop.barbershop.telefone.TelefoneDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class ClienteDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @NotNull(message = "O campo FOTO é requerido")
    private String foto;

    private Integer enderecoId;


    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDate dataCriacao = LocalDate.now();

    @JsonIgnore
    private List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();

    @JsonIgnore
    private List<AgendamentoDTO> agendamentos = new ArrayList<AgendamentoDTO>();


    public ClienteDTO(Cliente obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.senha = obj.getSenha();
        this.email = obj.getEmail();
        this.dataNascimento = obj.getDataNascimento();
        this.foto = obj.getFoto();
        this.dataCriacao = obj.getDataCriacao();
        this.enderecoId = obj.getEndereco().getId();
    }



}

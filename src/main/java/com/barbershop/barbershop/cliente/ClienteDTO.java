package com.barbershop.barbershop.cliente;


import com.barbershop.barbershop.agendamento.AgendamentoDTO;
import com.barbershop.barbershop.endereco.Endereco;
import com.barbershop.barbershop.login.LoginGetDTO;
import com.barbershop.barbershop.telefone.TelefoneDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@ToString
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

    @NotNull(message = "O campo Nome é requerido")
    private String sobreNome;

    @NotNull(message = "O campo CPF é requerido")
    @CPF
    private String cpf;


    @NotNull(message = "O campo DATANASCIMENTO é requerido")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @NotNull(message = "O campo FOTO é requerido")
    private String foto;


    private Endereco endereco;


    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCriacao = LocalDate.now();

    @JsonIgnore
    private List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();

    @JsonIgnore
    private List<AgendamentoDTO> agendamentos = new ArrayList<AgendamentoDTO>();

    @JsonIgnore
    private List<LoginGetDTO> loginGetDTOS = new ArrayList<LoginGetDTO>();



}

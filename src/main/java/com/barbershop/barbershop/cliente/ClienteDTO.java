package com.barbershop.barbershop.cliente;


import com.barbershop.barbershop.agendamento.AgendamentoDTO;
import com.barbershop.barbershop.endereco.Endereco;
import com.barbershop.barbershop.enuns.Perfil;
import com.barbershop.barbershop.login.LoginDTO;
import com.barbershop.barbershop.telefone.TelefoneDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "O campo Nome é requerido")
    private String nome;

    @NotBlank(message = "O campo Nome é requerido")
    private String sobreNome;

    @NotBlank(message = "O campo CPF é requerido")
    @CPF
    private String cpf;


    @NotNull(message = "O campo DATANASCIMENTO é requerido")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @NotNull(message = "O campo FOTO é requerido")
    private String foto;

    private Perfil perfil;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCriacao = LocalDate.now();

    private Endereco endereco;

    private List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();


    private List<AgendamentoDTO> agendamentos = new ArrayList<AgendamentoDTO>();


    private List<LoginDTO> logins = new ArrayList<LoginDTO>();


    @Override
    public String toString() {
        return "ClienteDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", foto='" + foto + '\'' +
                ", perfil=" + perfil +
                ", dataCriacao=" + dataCriacao +
                ", endereco=" + endereco +
                '}';
    }
}

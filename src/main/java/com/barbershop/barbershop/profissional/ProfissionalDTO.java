package com.barbershop.barbershop.profissional;

import com.barbershop.barbershop.barbearia.Barbearia;
import com.barbershop.barbershop.endereco.Endereco;
import com.barbershop.barbershop.enuns.Perfil;
import com.barbershop.barbershop.profissionalServico.ProfissionalServico;
import com.barbershop.barbershop.telefone.Telefone;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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

public class ProfissionalDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    private Integer id;

    @NotBlank(message = "O campo Nome é requerido")
    private String nome;

    @NotBlank(message = "O campo sobrenome é requerido")
    private String sobreNome;

    @NotBlank(message = "O campo CPF é requerido")
    @CPF
    private String cpf;

    @NotNull(message = "O campo DATANASCIMENTO é requerido")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @NotNull(message = "O campo FOTO é requerido")
    private String foto;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCriacao = LocalDate.now();


    private Perfil perfil;


    private Endereco endereco;


    private Barbearia barbearia;


    private List<Telefone> telefones = new ArrayList<Telefone>();

    private List<ProfissionalServico> profissionalServicos = new ArrayList<ProfissionalServico>();


    @Override
    public String toString() {
        return "ProfissionalDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", foto='" + foto + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", perfil=" + perfil +
                ", endereco=" + endereco +
                ", barbearia=" + barbearia +
                '}';
    }
}

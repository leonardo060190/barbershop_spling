package com.barbershop.barbershop.login;

import com.barbershop.barbershop.barbearia.Barbearia;
import com.barbershop.barbershop.cliente.Cliente;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Login implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(length = 200, unique = true)
        private String email;

        @Column(length = 150, unique = true)
        private String senha;

        @Column(length=10, nullable=false)
        private LocalDate dataCriacao = LocalDate.now();

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "barbeariaId")
        @JsonBackReference("barbearia_logins")
        private Barbearia barbearia;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "clienteId")
        @JsonBackReference("cliente_logins")
        private Cliente cliente;

        @Override
        public String toString() {
                return "Login{" +
                        "id=" + id +
                        ", email='" + email + '\'' +
                        ", senha='" + senha + '\'' +
                        ", dataCriacao=" + dataCriacao +
                        '}';
        }
}

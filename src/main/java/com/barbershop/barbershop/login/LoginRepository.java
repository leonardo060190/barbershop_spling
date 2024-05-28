package com.barbershop.barbershop.login;

import com.barbershop.barbershop.telefone.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {
}

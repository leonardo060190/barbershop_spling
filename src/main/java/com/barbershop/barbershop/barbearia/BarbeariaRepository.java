package com.barbershop.barbershop.barbearia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarbeariaRepository extends JpaRepository<Barbearia, Integer>{
}

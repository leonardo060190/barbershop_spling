package com.barbershop.barbershop.barbearia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarbeariaRepository extends JpaRepository<Barbearia, Integer>{

    //pesquisa com like
    List<Barbearia> findByNomeContainingIgnoreCase(String nome);

}

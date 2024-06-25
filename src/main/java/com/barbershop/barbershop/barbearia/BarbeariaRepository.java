package com.barbershop.barbershop.barbearia;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarbeariaRepository extends JpaRepository<Barbearia, Integer>{

    //pesquisa com like
    List<Barbearia> findByNomeContainingIgnoreCase(String nome);

    //pesquisa com paginação
    Page<Barbearia> findAll(Pageable pageable);
}

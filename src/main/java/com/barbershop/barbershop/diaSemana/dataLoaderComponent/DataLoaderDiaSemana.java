package com.barbershop.barbershop.diaSemana.dataLoaderComponent;

import com.barbershop.barbershop.diaSemana.DiaSemana;
import com.barbershop.barbershop.diaSemana.DiaSemanaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoaderDiaSemana implements CommandLineRunner {
    private final DiaSemanaRepository diaSemanaRepository;

    @Autowired
    public DataLoaderDiaSemana(DiaSemanaRepository diaSemanaRepository){
        this.diaSemanaRepository = diaSemanaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (diaSemanaRepository.count() == 0) {
        // Inserir dados iniciais
        List<DiaSemana> diasSemana = Arrays.asList(
                new DiaSemana("Segunda", LocalDate.now()),
                new DiaSemana("Terça", LocalDate.now()),
                new DiaSemana("Quarta", LocalDate.now()),
                new DiaSemana("Quinta", LocalDate.now()),
                new DiaSemana("Sexta", LocalDate.now()),
                new DiaSemana("Sábado", LocalDate.now()),
                new DiaSemana("Domingo", LocalDate.now())
        );
        diaSemanaRepository.saveAll(diasSemana);
    }}
}

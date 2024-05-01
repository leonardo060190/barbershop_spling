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
public class DataLoader implements CommandLineRunner {

    private final DiaSemanaRepository diaSemanaRepository;

    @Autowired
    public DataLoader(DiaSemanaRepository diaSemanaRepository) {
        this.diaSemanaRepository = diaSemanaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Inserir dados iniciais
        List<DiaSemana> diasSemana = Arrays.asList(
                new DiaSemana(null, "Segunda-feira", LocalDate.now()),
                new DiaSemana(null, "Terça-feira", LocalDate.now()),
                new DiaSemana(null, "Quarta-feira", LocalDate.now()),
                new DiaSemana(null, "Quinta-feira", LocalDate.now()),
                new DiaSemana(null, "Sexta-feira", LocalDate.now()),
                new DiaSemana(null, "Sábado", LocalDate.now()),
                new DiaSemana(null, "Domingo", LocalDate.now())
        );

        // Salvar no banco de dados
        diaSemanaRepository.saveAll(diasSemana);
    }
}
package com.barbershop.barbershop.estado.dataLoaderEstadoComponents;


import com.barbershop.barbershop.estado.Estado;
import com.barbershop.barbershop.estado.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoaderEstado implements CommandLineRunner {

    private final EstadoRepository estadoRepository;

    @Autowired
    public DataLoaderEstado(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Verificar se já existem estados no banco
        if (estadoRepository.count() == 0) {
            // Inserir estados do Brasil
            List<Estado> estados = Arrays.asList(
                    new Estado( "Acre", "AC", LocalDate.now()),
                    new Estado( "Alagoas", "AL", LocalDate.now()),
                    new Estado( "Amapá", "AP", LocalDate.now()),
                    new Estado( "Amazonas", "AM", LocalDate.now()),
                    new Estado( "Bahia", "BA", LocalDate.now()),
                    new Estado( "Ceará", "CE", LocalDate.now()),
                    new Estado( "Distrito Federal", "DF", LocalDate.now()),
                    new Estado( "Espírito Santo", "ES", LocalDate.now()),
                    new Estado( "Goiás", "GO", LocalDate.now()),
                    new Estado( "Maranhão", "MA", LocalDate.now()),
                    new Estado( "Mato Grosso", "MT", LocalDate.now()),
                    new Estado( "Mato Grosso do Sul", "MS", LocalDate.now()),
                    new Estado( "Minas Gerais", "MG", LocalDate.now()),
                    new Estado( "Pará", "PA", LocalDate.now()),
                    new Estado( "Paraíba", "PB", LocalDate.now()),
                    new Estado( "Paraná", "PR", LocalDate.now()),
                    new Estado( "Pernambuco", "PE", LocalDate.now()),
                    new Estado( "Piauí", "PI", LocalDate.now()),
                    new Estado( "Rio de Janeiro", "RJ", LocalDate.now()),
                    new Estado( "Rio Grande do Norte", "RN", LocalDate.now()),
                    new Estado( "Rio Grande do Sul", "RS", LocalDate.now()),
                    new Estado( "Rondônia", "RO", LocalDate.now()),
                    new Estado( "Roraima", "RR", LocalDate.now()),
                    new Estado( "Santa Catarina", "SC", LocalDate.now()),
                    new Estado( "São Paulo", "SP", LocalDate.now()),
                    new Estado( "Sergipe", "SE", LocalDate.now()),
                    new Estado( "Tocantins", "TO", LocalDate.now())
            );

            // Salvar estados no banco de dados
            estadoRepository.saveAll(estados);
        }
    }
}
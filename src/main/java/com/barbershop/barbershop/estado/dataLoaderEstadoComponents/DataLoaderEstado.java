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
                    new Estado(null, "Acre", "AC", LocalDate.now()),
                    new Estado(null, "Alagoas", "AL", LocalDate.now()),
                    new Estado(null, "Amazonas", "AM", LocalDate.now()),
                    new Estado( null,"Amapá", "AP", LocalDate.now()),
                    new Estado(null, "Bahia", "BA", LocalDate.now()),
                    new Estado( null,"Ceará", "CE", LocalDate.now()),
                    new Estado( null,"Distrito Federal", "DF", LocalDate.now()),
                    new Estado(null, "Espírito Santo", "ES", LocalDate.now()),
                    new Estado(null, "Goiás", "GO", LocalDate.now()),
                    new Estado( null,"Maranhão", "MA", LocalDate.now()),
                    new Estado( null,"Minas Gerais", "MG", LocalDate.now()),
                    new Estado(null, "Mato Grosso do Sul", "MS", LocalDate.now()),
                    new Estado( null,"Mato Grosso", "MT", LocalDate.now()),
                    new Estado( null,"Pará", "PA", LocalDate.now()),
                    new Estado(null, "Paraíba", "PB", LocalDate.now()),
                    new Estado(null, "Pernambuco", "PE", LocalDate.now()),
                    new Estado(null, "Piauí", "PI", LocalDate.now()),
                    new Estado( null,"Paraná", "PR", LocalDate.now()),
                    new Estado( null,"Rio de Janeiro", "RJ", LocalDate.now()),
                    new Estado( null,"Rio Grande do Norte", "RN", LocalDate.now()),
                    new Estado( null,"Rondônia", "RO", LocalDate.now()),
                    new Estado( null,"Roraima", "RR", LocalDate.now()),
                    new Estado( null,"Rio Grande do Sul", "RS", LocalDate.now()),
                    new Estado( null,"Santa Catarina", "SC", LocalDate.now()),
                    new Estado( null,"Sergipe", "SE", LocalDate.now()),
                    new Estado( null,"São Paulo", "SP", LocalDate.now()),
                    new Estado( null,"Tocantins", "TO", LocalDate.now())
            );

            // Salvar estados no banco de dados
            estadoRepository.saveAll(estados);
        }
    }
}
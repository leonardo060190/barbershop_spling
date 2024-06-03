package com.barbershop.barbershop.cidade.dataLoaderCidadesComponent;

import com.barbershop.barbershop.cidade.Cidade;
import com.barbershop.barbershop.cidade.CidadeDTO;
import com.barbershop.barbershop.cidade.CidadeRepository;
import com.barbershop.barbershop.estado.Estado;
import com.barbershop.barbershop.estado.EstadoRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

@Component
public class DataLoaderCidade implements CommandLineRunner {

    private final CidadeRepository cidadeRepository;
    private final EstadoRepository estadoRepository;

    @Autowired
    public DataLoaderCidade(CidadeRepository cidadeRepository, EstadoRepository estadoRepository) {
        this.cidadeRepository = cidadeRepository;
        this.estadoRepository = estadoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (cidadeRepository.count() == 0) {
            try {

                InputStream resource = new ClassPathResource("cidades.json").getInputStream();
                ObjectMapper objectMapper = new ObjectMapper();
                List<CidadeDTO> cidades = objectMapper.readValue(resource, new TypeReference<List<CidadeDTO>>() {});

                List<Estado> estados = estadoRepository.findAll();

                for (CidadeDTO cidadeDTO : cidades) {
                    Integer id = cidadeDTO.getEstado().getId();
                    Estado estado = estados.stream()
                            .filter(e -> e.getId().equals(id))
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("Estado not found"));

                    Cidade cidade = new Cidade();
                    cidade.setNome(cidadeDTO.getNome());
                    cidade.setEstado(estado);
                    cidade.setDataCriacao(LocalDate.now());
                    cidadeRepository.save(cidade);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

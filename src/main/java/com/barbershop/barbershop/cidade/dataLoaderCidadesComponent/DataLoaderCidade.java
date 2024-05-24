//package com.barbershop.barbershop.cidade.dataLoaderCidadesComponent;
//
//import com.barbershop.barbershop.cidade.Cidade;
//import com.barbershop.barbershop.cidade.CidadeRepository;
//import com.barbershop.barbershop.estado.Estado;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.List;
//
//@Component
//public class DataLoaderCidade implements CommandLineRunner {
//        private final CidadeRepository cidadeRepository;
//
//        @Autowired
//        public DataLoaderCidade(CidadeRepository cidadeRepository) {
//            this.cidadeRepository = cidadeRepository;
//        }
//
//        @Override
//        public void run(String... args) throws Exception {
//            if (cidadeRepository.count() == 0) {
//                List<Estado> cidades = Arrays.asList(
//
//                        new Cidade(null, "Afonso Cláudio", 8, LocalDate.now()),
//                        new Cidade( null,"Água Doce do Norte", 20, LocalDate.now())
//
//                        );
//                cidadeRepository.saveAll(cidades);
//            }
//        }

package com.barbershop.barbershop.DiaSemana;


import com.barbershop.barbershop.diaSemana.DiaSemana;
import com.barbershop.barbershop.estado.Estado;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.transaction.TestTransaction;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class DiaSemanaTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Verifica se a rota diaSemana está respondendo corretamente")
    void index() throws  Exception{
        mockMvc.perform(get("/diaSemana")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Verificar se está criando uma categoria")
    @Transactional
    @Rollback
    void create() throws Exception{
        DiaSemana diaSemanaExemplo = new DiaSemana();
        diaSemanaExemplo.setNome("Segunda");

        String jsonResquest = objectMapper.writeValueAsString(diaSemanaExemplo);

        mockMvc.perform(post("/diaSemana")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonResquest)).andExpect(status().isCreated());

        TestTransaction.end();
    }

    @Test
    @DisplayName("Verifica se está alterando o registro corretamente")
    @Transactional
    @Rollback
    void update() throws Exception{

        DiaSemana diaSemanaExemplo = new DiaSemana();
        diaSemanaExemplo.setNome("tarsa");

        String jsonRequest = objectMapper.writeValueAsString(diaSemanaExemplo);

        String response = mockMvc.perform(post("/diaSemana")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)).andExpect(status().isCreated())
                        .andReturn()
                        .getResponse()
                        .getContentAsString();

        JsonNode jsonNode = objectMapper.readTree(response);

        Integer id = jsonNode.get("id").asInt();

        DiaSemana diaSemanaUpdate = new DiaSemana();
        diaSemanaUpdate.setNome("terça");


        String jsonUpdateResquest = objectMapper.writeValueAsString(diaSemanaUpdate);

        mockMvc.perform(put("/diaSemana/"+id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonUpdateResquest))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.nome").value("terça"));

        TestTransaction.end();
    }
}

package com.barbershop.barbershop.Estado;

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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
public class EstadoTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Verifica um id inexistente")
    void idInexitente() throws Exception{
        mockMvc.perform(get("/estado/30"))
                .andExpect(status().isNotFound());
//                .andExpect(content().string("Estado não encontrado"));
    }

    @Test
    @DisplayName("Verifica se exite o id")
    void findById() throws Exception{
        mockMvc.perform(get("/estado/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Acre"));
    }

    @Test
    @DisplayName("verifica se está deletando")
    void deleteById() throws Exception{
        mockMvc.perform(delete("/estado/1"))
                .andExpect(status().isOk());
//
    }

    @Test
    @DisplayName("Verificar se a rota estado está respondendo corretamente")
    void index() throws Exception{
        mockMvc.perform(get("/estado")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Verificar se está criando uma categoria")
    @Transactional
    @Rollback
    void create() throws Exception{
        Estado estadoExemplo = new Estado();
        estadoExemplo.setNome("Santa Catarina");
        estadoExemplo.setSigla("SC");

        String jsonResquest = objectMapper.writeValueAsString(estadoExemplo);

        mockMvc.perform(post("/estado")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonResquest)).andExpect(status().isCreated());

        TestTransaction.end();
    }

    @Test
    @DisplayName("Verifica se está alterando o registro corretamente")
    @Transactional
    @Rollback
    void update() throws Exception{
        Estado estadoExemplo = new Estado();
        estadoExemplo.setNome("Sata Catarina");
        estadoExemplo.setSigla("sC");

        String jsonRequest = objectMapper.writeValueAsString(estadoExemplo);

        String response = mockMvc.perform(post("/estado")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest)).andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();

        JsonNode jsonNode = objectMapper.readTree(response);
        Integer id = jsonNode.get("id").asInt();

        Estado estadoUpdate = new Estado();
        estadoUpdate.setNome("Santa Catarina");
        estadoUpdate.setSigla("SC");
        estadoUpdate.setId(id);

        String jsonUpdateResquest = objectMapper.writeValueAsString(estadoUpdate);

        mockMvc.perform(put("/estado/"+id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonUpdateResquest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Santa Catarina"));

        TestTransaction.end();
    }
}

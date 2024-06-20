package com.barbershop.barbershop.Cliente;

import com.barbershop.barbershop.cliente.Cliente;
import com.barbershop.barbershop.cliente.ClienteDTO;
import com.barbershop.barbershop.cliente.ClienteService;
import com.barbershop.barbershop.endereco.EnderecoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EnderecoService enderecoService;

    @MockBean
    private ClienteService clienteService;

    @Test
    @DisplayName("Validar se um CPF inválido está salvando no banco")
    void validaCpf() throws  Exception{
        Cliente cliente = new Cliente();
        cliente.setCpf("111.111.111.11");
        cliente.setNome("Cliente");
        cliente.setSobreNome("Test");
        cliente.setDataNascimento(LocalDate.now());

        String jsonRequest = objectMapper.writeValueAsString(cliente);

        mockMvc.perform(post("/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isBadRequest());
    }

    @Test
    void create() throws Exception{
        Cliente cliente = new Cliente();
        cliente.setCpf("165.680.560-06");
        cliente.setSobreNome("");
        cliente.setSobreNome("");
        cliente.setDataNascimento(LocalDate.now());

        String jsonRequest = objectMapper.writeValueAsString(cliente);

        mockMvc.perform(post("/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                        .andExpect(status().isBadRequest());
    }

    @Test
    void createCorreto() throws Exception{
        Cliente cliente = new Cliente();
        cliente.setCpf("165.680.560-06");
        cliente.setNome("Leonardo");
        cliente.setSobreNome("Domingos");
        cliente.setFoto("Foto");
        cliente.setDataNascimento(LocalDate.now());

        String jsonRequest = objectMapper.writeValueAsString(cliente);

        mockMvc.perform(post("/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                        .andExpect(status().isCreated());
    }


}

package com.barbershop.barbershop.cliente;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    ClienteDTO toDTO(Cliente cliente);

    @Mapping(source = "id", target = "id")
    Cliente toEntity(ClienteDTO clienteDTO );

    //recebendo uma lista do estados
    List<ClienteDTO> toDTO(List<Cliente> clientes);

    //troca os dados de EstadoDTO par Estado(entidade)
    @Mappings({
            @Mapping(source = "clienteDTO.id", target = "id"),
            @Mapping(source = "clienteDTO.nome", target = "nome"),
            @Mapping(source = "clienteDTO.sobreNome", target = "sobreNome"),
            @Mapping(source = "clienteDTO.cpf", target = "cpf"),
            @Mapping(source = "clienteDTO.dataNascimento", target = "dataNascimento"),
            @Mapping(source = "clienteDTO.foto", target = "foto"),
            @Mapping(source = "clienteDTO.dataCriacao", target = "dataCriacao"),
            @Mapping(source = "clienteDTO.endereco", target = "endereco"),
            @Mapping(source = "clienteDTO.telefones", target = "telefones"),
            @Mapping(source = "clienteDTO.agendamentos", target = "agendamentos"),
            @Mapping(source = "clienteDTO.logins", target = "logins"),
            @Mapping(source = "clienteDTO.perfil", target = "perfil")
    })
    Cliente updateEntity(ClienteDTO clienteDTO, Cliente cliente);

}

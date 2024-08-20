package com.barbershop.barbershop.profissional;

import com.barbershop.barbershop.cliente.Cliente;
import com.barbershop.barbershop.cliente.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfissionalMapper {
    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    ProfissionalDTO toDTO(Profissional profissional);

    @Mapping(source = "id", target = "id")
    Profissional toEntity(ProfissionalDTO profissionalDTO );

    //recebendo uma lista do estados
    List<ProfissionalDTO> toDTO(List<Profissional> profissionais);

    //troca os dados de EstadoDTO par Estado(entidade)
    @Mappings({
            @Mapping(source = "profissionalDTO.id", target = "id"),
            @Mapping(source = "profissionalDTO.nome", target = "nome"),
            @Mapping(source = "profissionalDTO.sobreNome", target = "sobreNome"),
            @Mapping(source = "profissionalDTO.cpf", target = "cpf"),
            @Mapping(source = "profissionalDTO.dataNascimento", target = "dataNascimento"),
            @Mapping(source = "profissionalDTO.foto", target = "foto"),
            @Mapping(source = "profissionalDTO.dataCriacao", target = "dataCriacao"),
            @Mapping(source = "profissionalDTO.endereco", target = "endereco"),
            @Mapping(source = "profissionalDTO.telefones", target = "telefones"),
            @Mapping(source = "profissionalDTO.barbearia", target = "barbearia"),
            @Mapping(source = "profissionalDTO.perfil", target = "perfil"),
            @Mapping(source = "profissionalDTO.profissionalServicos", target = "profissionalServicos")
    })
    Profissional updateEntity(ProfissionalDTO profissionalDTO, Profissional profissional);

}

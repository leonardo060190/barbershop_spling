package com.barbershop.barbershop.estado;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstadoMapper {

    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    EstadoDTO toDTO(Estado estado);

    @Mapping(source = "id", target = "id")
    Estado toEntity(EstadoDTO estadoDTO);

    //recebendo uma lista do estados
    List<EstadoDTO> toDTO(List<Estado> estados);

    //troca os dados de EstadoDTO par Estado(entidade)
    @Mappings({
            @Mapping(source = "estadoDTO.id", target = "id"),
            @Mapping(source = "estadoDTO.nome", target = "nome"),
            @Mapping(source = "estadoDTO.sigla", target = "sigla"),
            @Mapping(source = "estadoDTO.dataCriacao", target = "dataCriacao"),
    })
    Estado updateEntity(EstadoDTO estadoDTO, Estado estado);

}

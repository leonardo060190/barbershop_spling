package com.barbershop.barbershop.cidade;



import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CidadeMapper {

    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    CidadeDTO toDTO(Cidade cidade);

    @Mapping(source = "id", target = "id")
    Cidade toEntity(CidadeDTO cidadeDTO );


    //recebendo uma lista do estados
    List<CidadeDTO> toDTO(List<Cidade> cidades);

    //troca os dados de EstadoDTO par Estado(entidade)
    @Mappings({
            @Mapping(source = "cidadeDTO.id", target = "id"),
            @Mapping(source = "cidadeDTO.nome", target = "nome"),
            @Mapping(source = "cidadeDTO.dataCriacao", target = "dataCriacao"),
            @Mapping(source = "cidadeDTO.estado", target = "estado"),
            @Mapping(source = "cidadeDTO.enderecos", target = "enderecos")
    })
    Cidade updateEntity(CidadeDTO cidadeDTO, Cidade cidade);

}

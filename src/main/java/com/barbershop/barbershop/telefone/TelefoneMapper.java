package com.barbershop.barbershop.telefone;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TelefoneMapper {

    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    TelefoneDTO toDTO(Telefone telefone);

    @Mapping(source = "id", target = "id")
    Telefone toEntity(TelefoneDTO telefoneDTO);

    //recebendo uma lista do estados
    List<TelefoneDTO> toDTO(List<Telefone> telefones);

    //troca os dados de EstadoDTO par Estado(entidade)
    @Mappings({
            @Mapping(source = "telefoneDTO.id", target = "id"),
            @Mapping(source = "telefoneDTO.numero", target = "numero"),
            @Mapping(source = "telefoneDTO.dataCriacao", target = "dataCriacao"),
            @Mapping(source = "telefoneDTO.barbearia", target = "barbearia"),
            @Mapping(source = "telefoneDTO.cliente", target = "cliente")
    })
    Telefone updateEntity(TelefoneDTO telefoneDTO, Telefone telefone);

}

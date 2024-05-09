package com.barbershop.barbershop.endereco;


import com.barbershop.barbershop.cidade.Cidade;
import com.barbershop.barbershop.estado.Estado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    EnderecoDTO toDTO(Endereco endereco);

    @Mapping(source = "id", target = "id")
    Endereco toEntity(EnderecoDTO enderecoDTO);


    List<EnderecoDTO> toDTO(List<Endereco> enderecos);


    @Mappings({
            @Mapping(source = "enderecoDTO.id", target = "id"),
            @Mapping(source = "enderecoDTO.rua", target = "rua"),
            @Mapping(source = "enderecoDTO.bairro", target = "bairro"),
            @Mapping(source = "enderecoDTO.numero", target = "numero"),
            @Mapping(source = "enderecoDTO.cep", target = "cep"),
            @Mapping(source = "enderecoDTO.dataCriacao", target = "dataCriacao"),
            @Mapping(source = "enderecoDTO.cidadeId", target = "cidade")

    })
    Endereco updateEntity(EnderecoDTO enderecoDTO, Endereco endereco);


}

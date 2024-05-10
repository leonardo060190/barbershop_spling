package com.barbershop.barbershop.barbearia;

import com.barbershop.barbershop.cidade.Cidade;
import com.barbershop.barbershop.cidade.CidadeDTO;
import com.barbershop.barbershop.endereco.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BarbeariaMapper {

    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    BarbeariaDTO toDTO(Barbearia barbearia);

    @Mapping(source = "id", target = "id")
    Barbearia toEntity(BarbeariaDTO barbeariaDTO );

    //recebendo uma lista do estados
    List<BarbeariaDTO> toDTO(List<Barbearia> barbearias);

    //troca os dados de EstadoDTO par Estado(entidade)
    @Mappings({
            @Mapping(source = "barbeariaDTO.id", target = "id"),
            @Mapping(source = "barbeariaDTO.nome", target = "nome"),
            @Mapping(source = "barbeariaDTO.cnpj", target = "cnpj"),
            @Mapping(source = "barbeariaDTO.email", target = "email"),
            @Mapping(source = "barbeariaDTO.foto", target = "foto"),
            @Mapping(source = "barbeariaDTO.senha", target = "senha"),
            @Mapping(source = "barbeariaDTO.razaoSocial", target = "razaoSocial"),
            @Mapping(source = "barbeariaDTO.dataCriacao", target = "dataCriacao"),
            @Mapping(source = "barbeariaDTO.enderecoId", target = "endereco"),
            @Mapping(source = "barbeariaDTO.servicos", target = "servicos"),
            @Mapping(source = "barbeariaDTO.horarioFuncionamentos", target = "horarioFuncionamentos"),
            @Mapping(source = "barbeariaDTO.telefones", target = "telefones")
    })
    Barbearia updateEntity(BarbeariaDTO barbeariaDTO, Barbearia barbearia);


}

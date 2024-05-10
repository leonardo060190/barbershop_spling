package com.barbershop.barbershop.servico;

import com.barbershop.barbershop.cidade.Cidade;
import com.barbershop.barbershop.cidade.CidadeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServicoMapper {

    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    ServicoDTO toDTO(Servico servico);

    @Mapping(source = "id", target = "id")
    Servico toEntity(ServicoDTO servicoDTO );

    //recebendo uma lista do estados
    List<ServicoDTO> toDTO(List<Servico> servicos);

    //troca os dados de EstadoDTO par Estado(entidade)
    @Mappings({
            @Mapping(source = "servicoDTO.id", target = "id"),
            @Mapping(source = "servicoDTO.nome", target = "nome"),
            @Mapping(source = "servicoDTO.preco", target = "preco"),
            @Mapping(source = "servicoDTO.descricao", target = "descricao"),
            @Mapping(source = "servicoDTO.foto", target = "foto"),
            @Mapping(source = "servicoDTO.dataCriacao", target = "dataCriacao"),
            @Mapping(source = "servicoDTO.barbeariaId", target = "barbearia"),
            @Mapping(source = "servicoDTO.agendamentos", target = "agendamentos"),
    })
    Servico updateEntity(ServicoDTO servicoDTO, Servico servico);

}

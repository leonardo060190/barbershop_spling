package com.barbershop.barbershop.barbearia;


import com.barbershop.barbershop.endereco.Endereco;
import com.barbershop.barbershop.endereco.EnderecoDTO;
import com.barbershop.barbershop.servico.Servico;
import com.barbershop.barbershop.servico.ServicoDTO;
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
            @Mapping(source = "barbeariaDTO.foto", target = "foto"),
            @Mapping(source = "barbeariaDTO.razaoSocial", target = "razaoSocial"),
            @Mapping(source = "barbeariaDTO.dataCriacao", target = "dataCriacao"),
            @Mapping(source = "barbeariaDTO.endereco", target = "endereco"),
            @Mapping(source = "barbeariaDTO.servicos", target = "servicos"),
            @Mapping(source = "barbeariaDTO.horarioFuncionamentos", target = "horarioFuncionamentos"),
            @Mapping(source = "barbeariaDTO.profissionais", target = "profissionais"),
            @Mapping(source = "barbeariaDTO.telefones", target = "telefones"),
            @Mapping(source = "barbeariaDTO.logins", target = "logins"),
            @Mapping(source = "barbeariaDTO.perfil", target = "perfil")

    })
    Barbearia updateEntity(BarbeariaDTO barbeariaDTO, Barbearia barbearia);



}

package com.barbershop.barbershop.profissionalServico;

import com.barbershop.barbershop.profissional.Profissional;
import com.barbershop.barbershop.profissional.ProfissionalDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfissionalServicoMapper {
    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    ProfissionalServicoDTO toDTO(ProfissionalServico profissionalServico);

    @Mapping(source = "id", target = "id")
    ProfissionalServico toEntity(ProfissionalServicoDTO profissionalServicoDTO );

    //recebendo uma lista do estados
    List<ProfissionalServicoDTO> toDTO(List<ProfissionalServico> profissionalServicos);

    //troca os dados de EstadoDTO par Estado(entidade)
    @Mappings({
            @Mapping(source = "profissionalServicoDTO.id", target = "id"),
            @Mapping(source = "profissionalServicoDTO.servico", target = "servico"),
            @Mapping(source = "profissionalServicoDTO.profissional", target = "profissional"),
            @Mapping(source = "profissionalServicoDTO.agendamentos", target = "agendamentos")


    })
    ProfissionalServico updateEntity(ProfissionalServicoDTO profissionalServicoDTO, ProfissionalServico profissionalServico);

}

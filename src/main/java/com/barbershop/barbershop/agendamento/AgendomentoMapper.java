package com.barbershop.barbershop.agendamento;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgendomentoMapper {

    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    AgendamentoDTO toDTO(Agendamento agendamento);

    @Mapping(source = "id", target = "id")
    Agendamento toEntity(AgendamentoDTO agendamentoDTO );

    //recebendo uma lista do estados
    List<AgendamentoDTO> toDTO(List<Agendamento> agendamentos);

    //troca os dados de EstadoDTO par Estado(entidade)
    @Mappings({
            @Mapping(source = "agendamentoDTO.id", target = "id"),
            @Mapping(source = "agendamentoDTO.data", target = "data"),
            @Mapping(source = "agendamentoDTO.hora", target = "hora"),
            @Mapping(source = "agendamentoDTO.cliente", target = "cliente"),
            @Mapping(source = "agendamentoDTO.servico", target = "servico"),
            @Mapping(source = "agendamentoDTO.profissionalServico", target = "profissionalServico"),
            @Mapping(source = "agendamentoDTO.dataCriacao", target = "dataCriacao"),
    })
    Agendamento updateEntity(AgendamentoDTO agendamentoDTO, Agendamento agendamento);

}

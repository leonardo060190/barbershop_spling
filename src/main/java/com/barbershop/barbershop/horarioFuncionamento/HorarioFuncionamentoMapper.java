package com.barbershop.barbershop.horarioFuncionamento;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HorarioFuncionamentoMapper {

    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    HorarioFuncionamentoDTO toDTO(HorarioFuncionamento horarioFuncionamento);

    @Mappings({
            @Mapping(source = "horarioFuncionamentoDTO.abri", target = "abri"),
            @Mapping(source = "horarioFuncionamentoDTO.fecha", target = "fecha"),
            @Mapping(source = "horarioFuncionamentoDTO.dataCriacao", target = "dataCriacao"),
            @Mapping(source = "horarioFuncionamentoDTO.barbearia", target = "barbearia"),
            @Mapping(source = "horarioFuncionamentoDTO.diaSemana", target = "diaSemana")
    })
    HorarioFuncionamento toEntity(HorarioFuncionamentoDTO horarioFuncionamentoDTO);

    //recebendo uma lista do estados
    List<HorarioFuncionamentoDTO> toDTO(List<HorarioFuncionamento> horariosFuncionamento);


    //troca os dados de EstadoDTO par Estado(entidade)
    @Mappings({
            @Mapping(source = "horarioFuncionamentoDTO.id", target = "id"),
            @Mapping(source = "horarioFuncionamentoDTO.abri", target = "abri"),
            @Mapping(source = "horarioFuncionamentoDTO.fecha", target = "fecha"),
            @Mapping(source = "horarioFuncionamentoDTO.dataCriacao", target = "dataCriacao"),
            @Mapping(source = "horarioFuncionamentoDTO.barbearia", target = "barbearia"),
            @Mapping(source = "horarioFuncionamentoDTO.diaSemana", target = "diaSemana")
    })
    HorarioFuncionamento updateEntity(HorarioFuncionamentoDTO horarioFuncionamentoDTO, HorarioFuncionamento horarioFuncionamento);



}

package com.barbershop.barbershop.horarioFuncionamento;

import com.barbershop.barbershop.estado.Estado;
import com.barbershop.barbershop.estado.EstadoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HorarioFuncionamentoMapper {

    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    HorarioFuncionamentoDTO toDTO(HorarioFuncionamento horarioFuncionamento);

    @Mapping(source = "id", target = "id")
    HorarioFuncionamento toEntity(HorarioFuncionamentoDTO horarioFuncionamentoDTO);

    //recebendo uma lista do estados
    List<HorarioFuncionamentoDTO> toDTO(List<HorarioFuncionamento> horariosFuncionamento);

    //troca os dados de EstadoDTO par Estado(entidade)
    @Mappings({
            @Mapping(source = "horarioFuncionamentoDTO.id", target = "id"),
            @Mapping(source = "horarioFuncionamentoDTO.inicio", target = "inicio"),
            @Mapping(source = "horarioFuncionamentoDTO.fim", target = "fim"),
            @Mapping(source = "horarioFuncionamentoDTO.dataCriacao", target = "dataCriacao"),
            @Mapping(source = "horarioFuncionamentoDTO.barbeariaId", target = "barbearia"),
            @Mapping(source = "horarioFuncionamentoDTO.diaSemanaId", target = "diaSemana")
    })
    HorarioFuncionamento updateEntity(HorarioFuncionamentoDTO horarioFuncionamentoDTO, HorarioFuncionamento horarioFuncionamento);


}

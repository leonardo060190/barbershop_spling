package com.barbershop.barbershop.diaSemana;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiaSemanaMapper {

    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    DiaSemanaDTO toDTO(DiaSemana diaSemana);

    @Mapping(source = "id", target = "id")
    DiaSemana toEntity(DiaSemanaDTO diaSemanaDTO);


    List<DiaSemanaDTO> toDTO(List<DiaSemana> diasSemana);


    @Mappings({
            @Mapping(source = "diaSemanaDTO.id", target = "id"),
            @Mapping(source = "diaSemanaDTO.nome", target = "nome"),
            @Mapping(source = "diaSemanaDTO.dataCriacao", target = "dataCriacao"),
            @Mapping(source = "diaSemanaDTO.horarioFuncionamentos", target = "horarioFuncionamentos"),

    })
    DiaSemana updateEntity(DiaSemanaDTO diaSemanaDTO, DiaSemana diaSemana);

}

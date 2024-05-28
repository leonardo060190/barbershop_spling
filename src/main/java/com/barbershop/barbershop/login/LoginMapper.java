package com.barbershop.barbershop.login;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoginMapper {

    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    LoginDTO toDTO(Login login);

    @Mapping(source = "id", target = "id")
    Login toEntity(LoginDTO loginDTO);

    List<LoginDTO> toDTO(List<Login> logins);


    @Mappings({
            @Mapping(source = "loginDTO.id", target = "id"),
            @Mapping(source = "loginDTO.email", target = "email"),
            @Mapping(source = "loginDTO.senha", target = "senha"),
            @Mapping(source = "loginDTO.dataCriacao", target = "dataCriacao"),
            @Mapping(source = "loginDTO.barbearia", target = "barbearia"),
            @Mapping(source = "loginDTO.cliente", target = "cliente")
    })
    Login updateEntity(LoginDTO loginDTO, Login login);

}

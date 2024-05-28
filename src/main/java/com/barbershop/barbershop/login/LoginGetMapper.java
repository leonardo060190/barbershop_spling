package com.barbershop.barbershop.login;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;

@Mapper(componentModel = "spring")
public interface LoginGetMapper {


    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    LoginGetDTO toDTO(Login login);

    List<LoginGetDTO> toDTO(List<Login> logins);


}

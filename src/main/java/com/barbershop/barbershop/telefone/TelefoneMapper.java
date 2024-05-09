package com.barbershop.barbershop.telefone;

import com.barbershop.barbershop.servico.Servico;
import com.barbershop.barbershop.servico.ServicoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TelefoneMapper {

    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    TelefoneDTO toDTO(Telefone telefone);

    @Mapping(source = "id", target = "id")
    Telefone toEntity(TelefoneDTO telefoneDTO);

    //recebendo uma lista do estados
    List<TelefoneDTO> toDTO(List<Telefone> telefones);

    //troca os dados de EstadoDTO par Estado(entidade)
    @Mappings({
            @Mapping(source = "telefoneDTO.id", target = "id"),
            @Mapping(source = "telefoneDTO.numero", target = "numero"),
            @Mapping(source = "telefoneDTO.barbeariaId", target = "barbearia"),
            @Mapping(source = "telefoneDTO.clienteId", target = "cliente")
    })
    Telefone updateEntity(TelefoneDTO telefoneDTO, Telefone telefone);

}

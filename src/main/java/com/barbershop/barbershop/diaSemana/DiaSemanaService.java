package com.barbershop.barbershop.diaSemana;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiaSemanaService {

    @Autowired
    private DiaSemanaRepository diaSemanaRepository;

    @Autowired
    private DiaSemanaMapper diaSemanaMapper;


    //busca todos os dias da semana
    public List<DiaSemanaDTO> findAll(){
        List<DiaSemana> diasSemana = diaSemanaRepository.findAll();
        return  diasSemana.stream().map(diaSemanaMapper::toDTO).collect(Collectors.toList());
    }

    //buscar por id
    public DiaSemanaDTO findById(Integer id){
        DiaSemana diaSemana = diaSemanaRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Dia semana não encotrado"));
        return diaSemanaMapper.toDTO(diaSemana);
    }

    //criando
    public DiaSemanaDTO create(DiaSemanaDTO DiaSemanaDTO){
        DiaSemana diaSemana = diaSemanaMapper.toEntity(DiaSemanaDTO);
        diaSemana = diaSemanaRepository.save(diaSemana);
        return diaSemanaMapper.toDTO(diaSemana);
    }

    //update
    public DiaSemanaDTO update(Integer id, DiaSemanaDTO DiaSemanaDTO){
        DiaSemana diaSemana = diaSemanaRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Dia semana não encotrado"));
        diaSemanaMapper.updateEntity(DiaSemanaDTO,diaSemana);
        diaSemana = diaSemanaRepository.save(diaSemana);
        return diaSemanaMapper.toDTO(diaSemana);
    }

    public void deleteById(Integer id){
        diaSemanaRepository.deleteById(id);
    }
}

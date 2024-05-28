package com.barbershop.barbershop.diaSemana;


import jakarta.transaction.Transactional;
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
        DiaSemana diaSemana = diaSemanaRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Dia semana não encontrado"));
        return diaSemanaMapper.toDTO(diaSemana);
    }

    //criando
    @Transactional
    public DiaSemanaDTO create(DiaSemanaDTO diaSemanaDTO){
        diaSemanaDTO.setId(null);
        DiaSemana diaSemana = diaSemanaMapper.toEntity(diaSemanaDTO);
        diaSemana = diaSemanaRepository.save(diaSemana);
        return diaSemanaMapper.toDTO(diaSemana);
    }

    //update
    @Transactional
    public DiaSemanaDTO update(Integer id, DiaSemanaDTO diaSemanaDTO){
        DiaSemana diaSemana = diaSemanaRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Dia semana não encontrado"));
        diaSemanaDTO.setId(id);
        diaSemana = diaSemanaMapper.updateEntity(diaSemanaDTO,diaSemana);
        diaSemana = diaSemanaRepository.save(diaSemana);
        return diaSemanaMapper.toDTO(diaSemana);
    }

    public void deleteById(Integer id){
        diaSemanaRepository.deleteById(id);
    }
}

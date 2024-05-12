package com.barbershop.barbershop.agendamento;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {


    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private AgendomentoMapper agendomentoMapper;


    //buscar todos s estados

    public List<AgendamentoDTO> findAll(){
        List<Agendamento> agendamentos = agendamentoRepository.findAll();
        return agendamentos.stream().map(agendomentoMapper::toDTO).collect(Collectors.toList());
    }

    //buscar por id
    public AgendamentoDTO findById(Integer id){
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Agendamento não encotrado"));
        return agendomentoMapper.toDTO(agendamento);
    }

    //criando um novo estado
    public AgendamentoDTO create(AgendamentoDTO agendamentoDTO){
        Agendamento agendamento = agendomentoMapper.toEntity(agendamentoDTO);
        agendamento = agendamentoRepository.save(agendamento);
        return agendomentoMapper.toDTO(agendamento);
    }

    //update estado
    public AgendamentoDTO update(Integer id, AgendamentoDTO agendamentoDTO){
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Agendamento não encotrado"));
        agendomentoMapper.updateEntity(agendamentoDTO,agendamento);
        agendamento = agendamentoRepository.save(agendamento);
        return agendomentoMapper.toDTO(agendamento);
    }

    public void deleteById(Integer id){
        agendamentoRepository.deleteById(id);
    }

}

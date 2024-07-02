package com.barbershop.barbershop.agendamento;


import jakarta.transaction.Transactional;
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


    //buscar todos os agendamentos
    public List<AgendamentoDTO> findAll(){
        List<Agendamento> agendamentos = agendamentoRepository.findAll();
        return agendamentos.stream().map(agendomentoMapper::toDTO).collect(Collectors.toList());
    }

    // Buscar agendamentos pela barbearia
    public List<AgendamentoDTO> findByBarbeariaId(Integer barbeariaId) {
        List<Agendamento> agendamentos = agendamentoRepository.findByServico_Barbearia_Id(barbeariaId);
        return agendamentos.stream().map(agendomentoMapper::toDTO).collect(Collectors.toList());
    }

    //buscar o agendamento pelo id
    public AgendamentoDTO findById(Integer id){
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Agendamento não encontrado"));
        return agendomentoMapper.toDTO(agendamento);
    }
    //buscar o agendamento pelo id do cliente
    public List<AgendamentoDTO> findByClienteId(Integer clienteId) {
        List<Agendamento> agendamentos = agendamentoRepository.findByClienteId(clienteId);
        return agendamentos.stream().map(agendomentoMapper::toDTO).collect(Collectors.toList());
    }

    //cria um novo agendamento
    @Transactional
    public AgendamentoDTO create(AgendamentoDTO agendamentoDTO){
        agendamentoDTO.setId(null);
        Agendamento agendamento = agendomentoMapper.toEntity(agendamentoDTO);
        agendamento = agendamentoRepository.save(agendamento);
        return agendomentoMapper.toDTO(agendamento);
    }

    //atualiza o agendamento pelo id
    @Transactional
    public AgendamentoDTO update(Integer id, AgendamentoDTO agendamentoDTO){
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Agendamento não encontrado"));
        agendamentoDTO.setId(id);
        agendamento = agendomentoMapper.updateEntity(agendamentoDTO,agendamento);
        agendamento = agendamentoRepository.save(agendamento);
        return agendomentoMapper.toDTO(agendamento);
    }

    //deleta um agendamento pelo id
    public void deleteById(Integer id){
        agendamentoRepository.deleteById(id);
    }

}

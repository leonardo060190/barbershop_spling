package com.barbershop.barbershop.agendamento;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
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

    // Buscar agendamentos pela barbearia com informações do serviço e profissional
    public List<AgendamentoDTO> findAgendamentosWithServiceAndProfessionalByBarbeariaId(Integer barbeariaId) {
        List<Agendamento> agendamentos = agendamentoRepository.findAgendamentosWithServiceAndProfessionalByBarbeariaId(barbeariaId);
        return agendamentos.stream().map(agendomentoMapper::toDTO).collect(Collectors.toList());
    }

    //buscar o agendamento pelo id
    public AgendamentoDTO findById(Integer id){
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Agendamento não encontrado"));
        return agendomentoMapper.toDTO(agendamento);
    }

    public List<AgendamentoDTO> findByProfissionalId(Integer profissionalId) {
        List<Agendamento> agendamentos = agendamentoRepository.findByProfissionalId(profissionalId);
        return agendamentos.stream().map(agendomentoMapper::toDTO).collect(Collectors.toList());
    }
    //buscar o agendamento pelo id do cliente
    public List<AgendamentoDTO> findByClienteId(Integer clienteId) {
        List<Agendamento> agendamentos = agendamentoRepository.findByClienteId(clienteId);
        return agendamentos.stream().map(agendomentoMapper::toDTO).collect(Collectors.toList());
    }

    //cria um novo agendamento
    @Transactional
    public AgendamentoDTO create(AgendamentoDTO agendamentoDTO){

        // Verificar se já existe um agendamento para o mesmo profissional, data e hora
        Integer profissionalId = agendamentoDTO.getProfissionalServico().getId();
        LocalDate data = agendamentoDTO.getData();
        LocalTime hora = agendamentoDTO.getHora();

        Optional<Agendamento> existingAgendamento = agendamentoRepository.findExistingAgendamento(profissionalId, data, hora);

        if (existingAgendamento.isPresent()) {
            throw new IllegalStateException("Já existe um agendamento para este profissional neste horário.");
        }
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

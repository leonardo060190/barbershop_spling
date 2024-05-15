package com.barbershop.barbershop.horarioFuncionamento;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HorarioFuncionamentoService {

    @Autowired
    private HorarioFuncionamentoRepository horarioFuncionamentoRepository;

    @Autowired
    private HorarioFuncionamentoMapper horarioFuncionamentoMapper;


    //busca todos os horarios de funcionamento
    public List<HorarioFuncionamentoDTO> findAll(){
        List<HorarioFuncionamento> horariosFuncionamento = horarioFuncionamentoRepository.findAll();
        return horariosFuncionamento.stream().map(horarioFuncionamentoMapper::toDTO).collect(Collectors.toList());
    }

    //busca um horario pelo id
    public HorarioFuncionamentoDTO findById(Integer id){
        HorarioFuncionamento horarioFuncionamento = horarioFuncionamentoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Horario de funcionamento não encontrado"));
        return horarioFuncionamentoMapper.toDTO(horarioFuncionamento);
    }

    //cria um novo horario
    @Transactional
    public HorarioFuncionamentoDTO create(HorarioFuncionamentoDTO horarioFuncionamentoDTO){
        HorarioFuncionamento horarioFuncionamento = horarioFuncionamentoMapper.toEntity(horarioFuncionamentoDTO);
        horarioFuncionamento = horarioFuncionamentoRepository.save(horarioFuncionamento);
        return horarioFuncionamentoMapper.toDTO(horarioFuncionamento);
    }

    //atualiza um horario pelo id
    @Transactional
    public HorarioFuncionamentoDTO update(Integer id, HorarioFuncionamentoDTO horarioFuncionamentoDTO){
        HorarioFuncionamento horarioFuncionamento = horarioFuncionamentoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Horario de funcionamento não encontrado"));
        horarioFuncionamentoDTO.setId(id);
        horarioFuncionamento = horarioFuncionamentoMapper.updateEntity(horarioFuncionamentoDTO,horarioFuncionamento);
        horarioFuncionamento = horarioFuncionamentoRepository.save(horarioFuncionamento);
        return horarioFuncionamentoMapper.toDTO(horarioFuncionamento);
    }

    //deleta um horario pelo id
    public void deleteById(Integer id){
        horarioFuncionamentoRepository.deleteById(id);
    }
}

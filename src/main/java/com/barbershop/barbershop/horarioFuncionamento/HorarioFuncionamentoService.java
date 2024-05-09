package com.barbershop.barbershop.horarioFuncionamento;

import com.barbershop.barbershop.estado.Estado;
import com.barbershop.barbershop.estado.EstadoDTO;
import com.barbershop.barbershop.estado.EstadoMapper;
import com.barbershop.barbershop.estado.EstadoRepository;
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


    //buscar todos s estados

    public List<HorarioFuncionamentoDTO> findAll(){
        List<HorarioFuncionamento> horariosFuncionamento = horarioFuncionamentoRepository.findAll();
        return horariosFuncionamento.stream().map(horarioFuncionamentoMapper::toDTO).collect(Collectors.toList());
    }

    //buscar por id
    public HorarioFuncionamentoDTO findById(Integer id){
        HorarioFuncionamento horarioFuncionamento = horarioFuncionamentoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Horario de funcionamento não encotrado"));
        return horarioFuncionamentoMapper.toDTO(horarioFuncionamento);
    }

    //criando um novo estado
    public HorarioFuncionamentoDTO create(HorarioFuncionamentoDTO horarioFuncionamentoDTO){
        HorarioFuncionamento horarioFuncionamento = horarioFuncionamentoMapper.toEntity(horarioFuncionamentoDTO);
        horarioFuncionamento = horarioFuncionamentoRepository.save(horarioFuncionamento);
        return horarioFuncionamentoMapper.toDTO(horarioFuncionamento);
    }

    //update estado
    public HorarioFuncionamentoDTO update(Integer id, HorarioFuncionamentoDTO horarioFuncionamentoDTO){
        HorarioFuncionamento horarioFuncionamento = horarioFuncionamentoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Horario de funcionamento não encotrado"));
        horarioFuncionamentoMapper.updateEntity(horarioFuncionamentoDTO,horarioFuncionamento);
        horarioFuncionamento = horarioFuncionamentoRepository.save(horarioFuncionamento);
        return horarioFuncionamentoMapper.toDTO(horarioFuncionamento);
    }

    public void deleteById(Integer id){
        horarioFuncionamentoRepository.deleteById(id);
    }
}

package com.barbershop.barbershop.estado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadoService {

    @Autowired
   private EstadoRepository estadoRepository;

    @Autowired
    private EstadoMapper estadoMapper;

    //buscar todos s estados

    public List<EstadoDTO> findAll(){
        List<Estado> estados = estadoRepository.findAll();
        return estados.stream().map(estadoMapper::toDTO).collect(Collectors.toList());
    }

    //buscar por id
    public EstadoDTO findById(Integer id){
        Estado estado = estadoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Estado não encotrado"));
        return estadoMapper.toDTO(estado);
    }

    //criando um novo estado
    public EstadoDTO create(EstadoDTO estadoDTO){
        Estado estado = estadoMapper.toEntity(estadoDTO);
        estado = estadoRepository.save(estado);
        return estadoMapper.toDTO(estado);
    }

    //update estado
    public EstadoDTO update(Integer id, EstadoDTO estadoDTO){
        Estado estado = estadoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Estado não encotrado"));
        estadoMapper.updateEntity(estadoDTO,estado);
        estado = estadoRepository.save(estado);
        return estadoMapper.toDTO(estado);
    }

    public void deleteById(Integer id){
        estadoRepository.deleteById(id);
    }
}

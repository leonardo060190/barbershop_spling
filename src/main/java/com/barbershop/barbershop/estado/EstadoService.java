package com.barbershop.barbershop.estado;

import jakarta.transaction.Transactional;
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


    //buscar todos os estados
    public List<EstadoDTO> findAll(){
        List<Estado> estados = estadoRepository.findAll();
        return estados.stream().map(estadoMapper::toDTO).collect(Collectors.toList());
    }

    //busca o estado pelo id
    public EstadoDTO findById(Integer id){
        Estado estado = estadoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Estado não encontrado"));
        return estadoMapper.toDTO(estado);
    }

    //cria um novo estado
    @Transactional
    public EstadoDTO create(EstadoDTO estadoDTO){
        estadoDTO.setId(null);
        Estado estado = estadoMapper.toEntity(estadoDTO);
        estado = estadoRepository.save(estado);
        return estadoMapper.toDTO(estado);
    }

    //atualiza o endereco pelo id
    @Transactional
    public EstadoDTO update(Integer id, EstadoDTO estadoDTO){
        Estado estado = estadoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Estado não encontrado"));
        estadoDTO.setId(id);
        estado = estadoMapper.updateEntity(estadoDTO,estado);
        estado = estadoRepository.save(estado);
        return estadoMapper.toDTO(estado);
    }

    //deleta um endereco pelo id
    public void deleteById(Integer id){
        estadoRepository.deleteById(id);
    }
}

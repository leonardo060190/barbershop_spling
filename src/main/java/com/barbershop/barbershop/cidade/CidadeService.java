package com.barbershop.barbershop.cidade;


import com.barbershop.barbershop.agendamento.Agendamento;
import com.barbershop.barbershop.agendamento.AgendamentoDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private CidadeMapper cidadeMapper;


    //buscar todas as cidades
    public List<CidadeDTO> findAll(){
        List<Cidade> cidades = cidadeRepository.findAll();
        return cidades.stream().map(cidadeMapper::toDTO).collect(Collectors.toList());
    }

    //buscar a cidade pelo id
    public CidadeDTO findById(Integer id){
        Cidade cidade = cidadeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Cidade não encontrada"));
        return cidadeMapper.toDTO(cidade);
    }

    //buscar o a cidade pelo estado
    public List<CidadeDTO> findByEstadoId(Integer estadoId) {
        List<Cidade> cidades = cidadeRepository.findByEstadoId(estadoId);
        return cidades.stream().map(cidadeMapper::toDTO).collect(Collectors.toList());
    }

    //criando uma nova cidade
    @Transactional
    public CidadeDTO create(CidadeDTO cidadeDTO){
        cidadeDTO.setId(null);
        Cidade cidade = cidadeMapper.toEntity(cidadeDTO);
        cidade = cidadeRepository.save(cidade);
        return cidadeMapper.toDTO(cidade);
    }

    //atualiza a cidade
    @Transactional
    public CidadeDTO update(Integer id, CidadeDTO cidadeDTO){
        Cidade cidade = cidadeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Cidade não encontrada"));
        cidadeDTO.setId(id);
        System.out.println("cidadeDTO" + cidadeDTO);
        cidade = cidadeMapper.updateEntity(cidadeDTO,cidade);
        System.out.println("cidade" + cidade);
        cidade = cidadeRepository.save(cidade);
        return cidadeMapper.toDTO(cidade);
    }

    //deleta a cidade pelo id
    public void deleteById(Integer id){
        cidadeRepository.deleteById(id);
    }


}

package com.barbershop.barbershop.servico;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ServicoMapper servicoMapper;


    //busca todos os serviços
    public List<ServicoDTO> findAll(){
        List<Servico> servicos = servicoRepository.findAll();
        return servicos.stream().map(servicoMapper::toDTO).collect(Collectors.toList());
    }

    //busca o serviço pelo id
    public ServicoDTO findById(Integer id){
        Servico servico = servicoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Serviço não encontrado"));
        return servicoMapper.toDTO(servico);
    }

    //criando um novo serviço
    @Transactional
    public ServicoDTO create(ServicoDTO servicoDTO){
        Servico servico = servicoMapper.toEntity(servicoDTO);
        servico = servicoRepository.save(servico);
        return servicoMapper.toDTO(servico);
    }

    //atualiza um serviço pelo id
    @Transactional
    public ServicoDTO update(Integer id, ServicoDTO servicoDTO){
        Servico servico = servicoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Serviço não encontrado"));
        servicoDTO.setId(id);
        servico = servicoMapper.updateEntity(servicoDTO,servico);
        servico = servicoRepository.save(servico);
        return servicoMapper.toDTO(servico);
    }

    //deleta um serviço pelo id
    public void deleteById(Integer id){
        servicoRepository.deleteById(id);
    }


}

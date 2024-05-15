package com.barbershop.barbershop.endereco;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoMapper enderecoMapper;


    //busca todos os endereços
    public List<EnderecoDTO> findAll(){
        List<Endereco> enderecos = enderecoRepository.findAll();
        return  enderecos.stream().map(enderecoMapper::toDTO).collect(Collectors.toList());
    }

    //busca o endereço pelo id
    public EnderecoDTO findById(Integer id){
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Endereço não encontrado"));
        return enderecoMapper.toDTO(endereco);
    }

    //cria um novo endereço
    @Transactional
    public EnderecoDTO create(EnderecoDTO enderecoDTO){
        Endereco endereco = enderecoMapper.toEntity(enderecoDTO);
        endereco = enderecoRepository.save(endereco);
        return enderecoMapper.toDTO(endereco);
    }

    //atualiza o endereco pelo id
    @Transactional
    public EnderecoDTO update(Integer id, EnderecoDTO enderecoDTO){
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Endereço não encontrado"));
        enderecoDTO.setId(id);
        endereco = enderecoMapper.updateEntity(enderecoDTO,endereco);
        endereco = enderecoRepository.save(endereco);
        return enderecoMapper.toDTO(endereco);
    }

    //deleta um endereco pelo id
    public void deleteById(Integer id){
        enderecoRepository.deleteById(id);
    }
}

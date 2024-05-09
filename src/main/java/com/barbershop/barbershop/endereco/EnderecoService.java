package com.barbershop.barbershop.endereco;

import com.barbershop.barbershop.diaSemana.DiaSemana;
import com.barbershop.barbershop.diaSemana.DiaSemanaDTO;

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


    //busca todos os dias da semana
    public List<EnderecoDTO> findAll(){
        List<Endereco> enderecos = enderecoRepository.findAll();
        return  enderecos.stream().map(enderecoMapper::toDTO).collect(Collectors.toList());
    }

    //buscar por id
    public EnderecoDTO findById(Integer id){
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Endereço não encotrado"));
        return enderecoMapper.toDTO(endereco);
    }

    //criando
    public EnderecoDTO create(EnderecoDTO enderecoDTO){
        Endereco endereco = enderecoMapper.toEntity(enderecoDTO);
        endereco = enderecoRepository.save(endereco);
        return enderecoMapper.toDTO(endereco);
    }

    //update
    public EnderecoDTO update(Integer id, EnderecoDTO enderecoDTO){
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Endereço não encotrado"));
        enderecoMapper.updateEntity(enderecoDTO,endereco);
        endereco = enderecoRepository.save(endereco);
        return enderecoMapper.toDTO(endereco);
    }

    public void deleteById(Integer id){
        enderecoRepository.deleteById(id);
    }
}

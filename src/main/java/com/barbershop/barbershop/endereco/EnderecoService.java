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
    public List<DiaSemanaDTO> findAll(){
        List<Endereco> enderecos = enderecoRepository.findAll();
        return  enderecos.stream().map(enderecoMapper::toDTO).collect(Collectors.toList());
    }

    //buscar por id
    public EnderecoDTO findById(Integer id){
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Endereço não encotrado"));
        return enderecoMapper.toDTO(endereco);
    }

    //criando
    public EnderecoDTO create(EnderecoDTO EnderecoDTO){
        Endereco endereco = enderecoMapper.toEntity(EnderecoDTO);
        endereco = enderecoRepository.save(endereco);
        return enderecoMapper.toDTO(endereco);
    }

    //update
    public EnderecoDTO update(Integer id, EnderecoDTO EnderecoDTO){
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Endereço não encotrado"));
        enderecoMapper.updateEntity(EnderecoDTO,endereco);
        endereco = enderecoRepository.save(endereco);
        return enderecoMapper.toDTO(endereco);
    }

    public void deleteById(Integer id){
        enderecoRepository.deleteById(id);
    }
}

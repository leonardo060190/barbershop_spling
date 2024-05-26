package com.barbershop.barbershop.telefone;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private TelefoneMapper telefoneMapper;


    //busca todos os telefones
    public List<TelefoneDTO> findAll(){
        List<Telefone> telefones = telefoneRepository.findAll();
        return telefones.stream().map(telefoneMapper::toDTO).collect(Collectors.toList());
    }

    //busca o telefone pelo id
    public TelefoneDTO findById(Integer id){
        Telefone telefone = telefoneRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Telefone não encontrado"));
        return telefoneMapper.toDTO(telefone);
    }

    //cria um novo telefone
    @Transactional
    public TelefoneDTO create(TelefoneDTO telefoneDTO){
        System.out.println(telefoneDTO);
        Telefone telefone = telefoneMapper.toEntity(telefoneDTO);
        System.out.println(telefone);
        telefone = telefoneRepository.save(telefone);
        return telefoneMapper.toDTO(telefone);
    }

    //atualiza o telefone pelo id
    @Transactional
    public TelefoneDTO update(Integer id, TelefoneDTO telefoneDTO){
        Telefone telefone = telefoneRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Telefone não encontrado"));
        telefoneDTO.setId(id);
        telefone = telefoneMapper.updateEntity(telefoneDTO,telefone);
        telefone = telefoneRepository.save(telefone);
        return telefoneMapper.toDTO(telefone);
    }

    //deleta um telefone pelo id
    public void deleteById(Integer id){
        telefoneRepository.deleteById(id);
    }


}

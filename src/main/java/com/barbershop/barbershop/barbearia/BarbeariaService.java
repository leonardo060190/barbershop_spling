package com.barbershop.barbershop.barbearia;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BarbeariaService {

    @Autowired
    private BarbeariaRepository barbeariaRepository;

    @Autowired
    private BarbeariaMapper barbeariaMapper;



    //buscar todas as barbearias
    public List<BarbeariaDTO> findAll(){
        List<Barbearia> barbearias = barbeariaRepository.findAll();
        return barbearias.stream().map(barbeariaMapper::toDTO).collect(Collectors.toList());
    }

    //buscar a barbearia pelo id
    public BarbeariaDTO findById(Integer id){
        Barbearia barbearia = barbeariaRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Barbearia não encontrada"));
        return barbeariaMapper.toDTO(barbearia);
    }

    //busca pelo nome com a utilização do like
    public List<BarbeariaDTO> findByName(String nome) {
        List<Barbearia> barbearias = barbeariaRepository.findByNomeContainingIgnoreCase(nome);
        return barbearias.stream()
                .map(barbeariaMapper::toDTO)
                .collect(Collectors.toList());
    }


    //cria uma nova barbearia
    @Transactional
    public BarbeariaDTO create(BarbeariaDTO barbeariaDTO){
        barbeariaDTO.setId(null);
        Barbearia barbearia = barbeariaMapper.toEntity(barbeariaDTO);
        barbearia = barbeariaRepository.save(barbearia);
        return barbeariaMapper.toDTO(barbearia);
    }


    //atualiza a barbearia
    @Transactional
    public BarbeariaDTO update(Integer id, BarbeariaDTO barbeariaDTO){
        Barbearia barbearia = barbeariaRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Barbearia não encontrada"));
        barbeariaDTO.setId(id);
        barbearia = barbeariaMapper.updateEntity(barbeariaDTO,barbearia);
        barbearia = barbeariaRepository.save(barbearia);
        return barbeariaMapper.toDTO(barbearia);
    }

    //deleta uma barbearia pelo id
    public void deleteById(Integer id){
        barbeariaRepository.deleteById(id);
    }


}

package com.barbershop.barbershop.barbearia;

import com.barbershop.barbershop.cidade.Cidade;
import com.barbershop.barbershop.cidade.CidadeDTO;
import com.barbershop.barbershop.cidade.CidadeMapper;
import com.barbershop.barbershop.cidade.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BarbeariaService {

    @Autowired
    private BarbeariaRepository barbeariaRepository;

    @Autowired
    private BarbeariaMapper barbeariaMapper;


    //buscar todos s estados

    public List<BarbeariaDTO> findAll(){
        List<Barbearia> barbearias = barbeariaRepository.findAll();
        return barbearias.stream().map(barbeariaMapper::toDTO).collect(Collectors.toList());
    }

    //buscar por id
    public BarbeariaDTO findById(Integer id){
        Barbearia barbearia = barbeariaRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Barbearia não encotrado"));
        return barbeariaMapper.toDTO(barbearia);
    }

    //criando um novo estado
    public BarbeariaDTO create(BarbeariaDTO barbeariaDTO){
        Barbearia barbearia = barbeariaMapper.toEntity(barbeariaDTO);
        barbearia = barbeariaRepository.save(barbearia);
        return barbeariaMapper.toDTO(barbearia);
    }

    //update estado
    public BarbeariaDTO update(Integer id, BarbeariaDTO barbeariaDTO){
        Barbearia barbearia = barbeariaRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Barbearia não encotrado"));
        barbeariaMapper.updateEntity(barbeariaDTO,barbearia);
        barbearia = barbeariaRepository.save(barbearia);
        return barbeariaMapper.toDTO(barbearia);
    }

    public void deleteById(Integer id){
        barbeariaRepository.deleteById(id);
    }


}

package com.barbershop.barbershop.telefone;

import com.barbershop.barbershop.servico.Servico;
import com.barbershop.barbershop.servico.ServicoDTO;
import com.barbershop.barbershop.servico.ServicoMapper;
import com.barbershop.barbershop.servico.ServicoRepository;
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


    //buscar todos s estados

    public List<TelefoneDTO> findAll(){
        List<Telefone> telefones = telefoneRepository.findAll();
        return telefones.stream().map(telefoneMapper::toDTO).collect(Collectors.toList());
    }

    //buscar por id
    public TelefoneDTO findById(Integer id){
        Telefone telefone = telefoneRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Telefone não encotrado"));
        return telefoneMapper.toDTO(telefone);
    }

    //criando um novo estado
    public TelefoneDTO create(TelefoneDTO telefoneDTO){
        Telefone telefone = telefoneMapper.toEntity(telefoneDTO);
        telefone = telefoneRepository.save(telefone);
        return telefoneMapper.toDTO(telefone);
    }

    //update estado
    public TelefoneDTO update(Integer id, TelefoneDTO telefoneDTO){
        Telefone telefone = telefoneRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Telefone não encotrado"));
        telefoneMapper.updateEntity(telefoneDTO,telefone);
        telefone = telefoneRepository.save(telefone);
        return telefoneMapper.toDTO(telefone);
    }

    public void deleteById(Integer id){
        telefoneRepository.deleteById(id);
    }


}

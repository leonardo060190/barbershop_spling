package com.barbershop.barbershop.servico;

import com.barbershop.barbershop.cidade.Cidade;
import com.barbershop.barbershop.cidade.CidadeDTO;
import com.barbershop.barbershop.cidade.CidadeMapper;
import com.barbershop.barbershop.cidade.CidadeRepository;
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


    //buscar todos s estados

    public List<ServicoDTO> findAll(){
        List<Servico> servicos = servicoRepository.findAll();
        return servicos.stream().map(servicoMapper::toDTO).collect(Collectors.toList());
    }

    //buscar por id
    public ServicoDTO findById(Integer id){
        Servico servico = servicoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Serviço não encotrado"));
        return servicoMapper.toDTO(servico);
    }

    //criando um novo estado
    public ServicoDTO create(ServicoDTO servicoDTO){
        Servico servico = servicoMapper.toEntity(servicoDTO);
        servico = servicoRepository.save(servico);
        return servicoMapper.toDTO(servico);
    }

    //update estado
    public ServicoDTO update(Integer id, ServicoDTO servicoDTO){
        Servico servico = servicoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Serviço não encotrado"));
        servicoMapper.updateEntity(servicoDTO,servico);
        servico = servicoRepository.save(servico);
        return servicoMapper.toDTO(servico);
    }

    public void deleteById(Integer id){
        servicoRepository.deleteById(id);
    }


}

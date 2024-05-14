package com.barbershop.barbershop.cidade;

import com.barbershop.barbershop.estado.Estado;
import com.barbershop.barbershop.estado.EstadoDTO;
import com.barbershop.barbershop.estado.EstadoMapper;
import com.barbershop.barbershop.estado.EstadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
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


    //buscar todos s estados

    public List<CidadeDTO> findAll(){
        List<Cidade> cidades = cidadeRepository.findAll();
        return cidades.stream().map(cidadeMapper::toDTO).collect(Collectors.toList());
    }

    //buscar por id
    public CidadeDTO findById(Integer id){
        Cidade cidade = cidadeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Cidade não encotrado"));
        return cidadeMapper.toDTO(cidade);
    }

    //criando um novo estado
    @Transactional
    public CidadeDTO create(CidadeDTO cidadeDTO){
        System.out.println(cidadeDTO);
        Cidade cidade = cidadeMapper.toEntity(cidadeDTO);
        cidade = cidadeRepository.save(cidade);
        return cidadeMapper.toDTO(cidade);
    }

    //update estado
    @Transactional
    public CidadeDTO update(Integer id, CidadeDTO cidadeDTO){
        Cidade cidade = cidadeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Cidade não encotrado"));
//        cidadeMapper.updateEntity(cidadeDTO,cidade);
//        cidade = cidadeRepository.save(cidade);
        BeanUtils.copyProperties(cidadeDTO, cidade, "id");
        cidade = cidadeRepository.save(cidade);
        return cidadeMapper.toDTO(cidade);
    }

    public void deleteById(Integer id){
        cidadeRepository.deleteById(id);
    }


}

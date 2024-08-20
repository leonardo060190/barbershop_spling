package com.barbershop.barbershop.profissional;



import com.barbershop.barbershop.endereco.Endereco;
import com.barbershop.barbershop.enuns.Perfil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private ProfissionalMapper profissionalMapper;


    //buscar todos os profissionais
    public List<ProfissionalDTO> findAll(){
        List<Profissional> profissionais = profissionalRepository.findAll();
        return profissionais.stream().map(profissionalMapper::toDTO).collect(Collectors.toList());
    }

    // Buscar profissional pela barbearia
    public List<ProfissionalDTO> findByBarbeariaId(Integer barbeariaId) {
        List<Profissional> profissionais = profissionalRepository.findByBarbeariaId(barbeariaId);
        return profissionais.stream().map(profissionalMapper::toDTO).collect(Collectors.toList());
    }


    //buscar um profissional pelo id
    public ProfissionalDTO findById(Integer id){
        Profissional profissional = profissionalRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Profissional não encontrado"));
        return profissionalMapper.toDTO(profissional);
    }


    //cria uma novo profissonal
    @Transactional
    public ProfissionalDTO create(ProfissionalDTO profissionalDTO){
        profissionalDTO.setId(null);
        Profissional profissional = profissionalMapper.toEntity(profissionalDTO);
        profissional.setPerfil(Perfil.PROFISSIONAL);
        profissional = profissionalRepository.save(profissional);
        return profissionalMapper.toDTO(profissional);
    }

    //atualiza um profissional pelo id
    @Transactional
    public ProfissionalDTO update(Integer id, ProfissionalDTO profissionalDTO){
        Profissional profissional = profissionalRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Profissional não encontrado"));
        profissionalDTO.setId(id);
        Endereco end = profissional.getEndereco();

        profissional = profissionalMapper.updateEntity(profissionalDTO,profissional);
        profissional.setPerfil(Perfil.PROFISSIONAL);
        profissional.setEndereco(end);
        profissional = profissionalRepository.save(profissional);
        return profissionalMapper.toDTO(profissional);
    }

    //deleta uma profissional pelo id
    public void deleteById(Integer id){
        profissionalRepository.deleteById(id);
    }

}

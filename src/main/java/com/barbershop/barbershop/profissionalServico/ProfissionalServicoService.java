package com.barbershop.barbershop.profissionalServico;

import com.barbershop.barbershop.agendamento.Agendamento;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfissionalServicoService {

    @Autowired
    private ProfissionalServicoRepository profissionalServicoRepository;

    @Autowired
    private ProfissionalServicoMapper profissionalServicoMapper;


    //buscar todos os profissionalServicos
    public List<ProfissionalServicoDTO> findAll(){
        List<ProfissionalServico> profissionalServicos = profissionalServicoRepository.findAll();
        return profissionalServicos.stream().map(profissionalServicoMapper::toDTO).collect(Collectors.toList());
    }

    public List<ProfissionalServicoDTO> findByProfissionalId(Integer profissionalId) {
        List<ProfissionalServico> profissionalServicos = profissionalServicoRepository.findByProfissionalId(profissionalId);
        return profissionalServicos.stream().map(profissionalServicoMapper::toDTO).collect(Collectors.toList());
    }

    //buscar um profissionalServico pelo id
    public ProfissionalServicoDTO findById(Integer id){
        ProfissionalServico profissionalServico = profissionalServicoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("ProfissionalServico não encontrado"));
        return profissionalServicoMapper.toDTO(profissionalServico);
    }

    //cria uma novo profissionalServicos
    @Transactional
    public ProfissionalServicoDTO create(ProfissionalServicoDTO profissionalServicoDTO){
        profissionalServicoDTO.setId(null);
        ProfissionalServico profissionalServico = profissionalServicoMapper.toEntity(profissionalServicoDTO);
        profissionalServico = profissionalServicoRepository.save(profissionalServico);
        return profissionalServicoMapper.toDTO(profissionalServico);
    }

    //atualiza um profissionalServico pelo id
    @Transactional
    public ProfissionalServicoDTO update(Integer id, ProfissionalServicoDTO profissionalServicoDTO){
        ProfissionalServico profissionalServico = profissionalServicoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("ProfissionalServico não encontrado"));
        profissionalServicoDTO.setId(id);

        profissionalServico = profissionalServicoMapper.updateEntity(profissionalServicoDTO,profissionalServico);
        profissionalServico = profissionalServicoRepository.save(profissionalServico);
        return profissionalServicoMapper.toDTO(profissionalServico);
    }

    //deleta uma profissionalServico pelo id
    public void deleteById(Integer id){
        profissionalServicoRepository.deleteById(id);
    }

}

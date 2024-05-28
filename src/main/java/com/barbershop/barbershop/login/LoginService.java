package com.barbershop.barbershop.login;

import com.barbershop.barbershop.telefone.Telefone;
import com.barbershop.barbershop.telefone.TelefoneDTO;
import com.barbershop.barbershop.telefone.TelefoneMapper;
import com.barbershop.barbershop.telefone.TelefoneRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private LoginGetMapper loginGetMapper;


    //busca todos os logins
    public List<LoginGetDTO> findAll(){
        List<Login> logins = loginRepository.findAll();
        return logins.stream().map(loginGetMapper::toDTO).collect(Collectors.toList());
    }

    //busca o login pelo id
    public LoginGetDTO findById(Integer id){
        Login login = loginRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Login não encontrado"));
        return loginGetMapper.toDTO(login);
    }

    //cria um novo login
    @Transactional
    public LoginDTO create(LoginDTO loginDTO){
        loginDTO.setId(null);
        Login login = loginMapper.toEntity(loginDTO);
        login = loginRepository.save(login);
        return loginMapper.toDTO(login);
    }

    //atualiza o login pelo id
    @Transactional
    public LoginDTO update(Integer id, LoginDTO loginDTO){
        Login login = loginRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Login não encontrado"));
        loginDTO.setId(id);
        login = loginMapper.updateEntity(loginDTO,login);
        login = loginRepository.save(login);
        return loginMapper.toDTO(login);
    }

    //deleta um login pelo id
    public void deleteById(Integer id){
        loginRepository.deleteById(id);
    }


}

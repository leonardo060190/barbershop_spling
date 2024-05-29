package com.barbershop.barbershop.login;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private PasswordEncoder passwordEncoder;


    //busca todos os logins
    public List<LoginDTO> findAll(){
        List<Login> logins = loginRepository.findAll();
        return logins.stream().map(loginMapper::toDTO).collect(Collectors.toList());
    }

    //busca o login pelo id
    public LoginDTO findById(Integer id){
        Login login = loginRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Login não encontrado"));
        return loginMapper.toDTO(login);
    }

    //cria um novo login
    @Transactional
    public LoginDTO create(LoginDTO loginDTO){
        loginDTO.setId(null);
        Login login = loginMapper.toEntity(loginDTO);
        login.setSenha(passwordEncoder.encode(login.getSenha()));
        login = loginRepository.save(login);
        return loginMapper.toDTO(login);
    }

    //atualiza o login pelo id
    @Transactional
    public LoginDTO update(Integer id, LoginDTO loginDTO){
        Login login = loginRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Login não encontrado"));
        loginDTO.setId(id);
        login = loginMapper.updateEntity(loginDTO,login);
        if (loginDTO.getSenha()!=null){
            login.setSenha(passwordEncoder.encode(login.getSenha()));
        }
        login = loginRepository.save(login);
        return loginMapper.toDTO(login);
    }

    //deleta um login pelo id
    public void deleteById(Integer id){
        loginRepository.deleteById(id);
    }


}

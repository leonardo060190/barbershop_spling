package com.barbershop.barbershop.login;


import com.barbershop.barbershop.barbearia.Barbearia;
import com.barbershop.barbershop.barbearia.BarbeariaService;
import com.barbershop.barbershop.cliente.Cliente;
import com.barbershop.barbershop.cliente.ClienteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private ClienteService clienteService;

    @Autowired
    private BarbeariaService barbeariaService;


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
//        setClienteOuBarbearia(loginDTO, login);
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


    public LoginDTO loginUser(LoginRequest loginRequest){
        Optional<Login>loginOptional = loginRepository.findByEmail(loginRequest.getEmail());
        if (loginOptional.isEmpty()){
            return null;
        }
        Login login = loginOptional.get();
        if (!passwordEncoder.matches(loginRequest.getSenha(), login.getSenha())){
            return null;
        }
        return loginMapper.toDTO(login);

    }

//    private void setClienteOuBarbearia(LoginDTO loginDTO, Login login){
//        if (loginDTO.getCliente() != null && loginDTO.getCliente().getId() != null){
//            Cliente cliente = clienteService.findClienteById(loginDTO.getCliente().getId());
//            login.setCliente(cliente);
//        } else if (loginDTO.getBarbearia() != null && loginDTO.getBarbearia().getId() != null){
//            Barbearia barbearia = barbeariaService.findBarbeariaById(loginDTO.getBarbearia().getId());
//                login.setBarbearia(barbearia);
//            }
//        }

    }


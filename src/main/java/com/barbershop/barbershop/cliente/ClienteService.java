package com.barbershop.barbershop.cliente;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    //buscar todos os clientes
    public List<ClienteDTO> findAll(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(clienteMapper::toDTO).collect(Collectors.toList());
    }

    //buscar um cliente pelo id
    public ClienteDTO findById(Integer id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Cliente não encontrado"));
        return clienteMapper.toDTO(cliente);
    }

    //cria uma novo criente
    @Transactional
    public ClienteDTO create(ClienteDTO clienteDTO){
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toDTO(cliente);
    }

    //atualiza um cliente pelo id
    @Transactional
    public ClienteDTO update(Integer id, ClienteDTO clienteDTO){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Cliente não encontrado"));
        clienteDTO.setId(id);
        cliente = clienteMapper.updateEntity(clienteDTO,cliente);
        if (clienteDTO.getSenha()!=null){
            cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
        }
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toDTO(cliente);
    }

    //deleta uma cliente pelo id
    public void deleteById(Integer id){
        clienteRepository.deleteById(id);
    }

}

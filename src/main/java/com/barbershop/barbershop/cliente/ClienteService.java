package com.barbershop.barbershop.cliente;

import com.barbershop.barbershop.servico.Servico;
import com.barbershop.barbershop.servico.ServicoDTO;
import com.barbershop.barbershop.servico.ServicoMapper;
import com.barbershop.barbershop.servico.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;


    //buscar todos s estados

    public List<ClienteDTO> findAll(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(clienteMapper::toDTO).collect(Collectors.toList());
    }

    //buscar por id
    public ClienteDTO findById(Integer id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Cliente não encotrado"));
        return clienteMapper.toDTO(cliente);
    }

    //criando um novo estado
    public ClienteDTO create(ClienteDTO clienteDTO){
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toDTO(cliente);
    }

    //update estado
    public ClienteDTO update(Integer id, ClienteDTO clienteDTO){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Cliente não encotrado"));
        clienteMapper.updateEntity(clienteDTO,cliente);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toDTO(cliente);
    }

    public void deleteById(Integer id){
        clienteRepository.deleteById(id);
    }

}

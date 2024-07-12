package com.barbershop.barbershop.cliente;

import com.barbershop.barbershop.endereco.Endereco;
import com.barbershop.barbershop.enuns.Perfil;
import jakarta.transaction.Transactional;
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

    public Cliente findClienteById(Integer id) {
        return clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
    }

    //cria uma novo criente
    @Transactional
    public ClienteDTO create(ClienteDTO clienteDTO){
        clienteDTO.setId(null);
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        cliente.setPerfil(Perfil.CLIENTE);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toDTO(cliente);
    }

    //atualiza um cliente pelo id
    @Transactional
    public ClienteDTO update(Integer id, ClienteDTO clienteDTO){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Cliente não encontrado"));
        clienteDTO.setId(id);
        Endereco end = cliente.getEndereco();

        cliente = clienteMapper.updateEntity(clienteDTO,cliente);
        cliente.setPerfil(Perfil.CLIENTE);
        cliente.setEndereco(end);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toDTO(cliente);
    }

    //deleta uma cliente pelo id
    public void deleteById(Integer id){
        clienteRepository.deleteById(id);
    }

}

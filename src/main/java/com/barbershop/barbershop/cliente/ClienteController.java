package com.barbershop.barbershop.cliente;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = " http://localhost:5173")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAll(){
        List<ClienteDTO> clientesDTO = clienteService.findAll();
        return ResponseEntity.ok(clientesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable Integer id){
        try {
            ClienteDTO clienteDTO = clienteService.findById(id);
            return ResponseEntity.ok(clienteDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();}
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO clienteDTO){
        ClienteDTO create = clienteService.create(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO clienteDTO){
        ClienteDTO update = clienteService.update(id, clienteDTO);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Valid> delete(@PathVariable Integer id){
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

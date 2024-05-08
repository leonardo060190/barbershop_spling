package com.barbershop.barbershop.endereco;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<enderecoDTO>> getAll(){
        List<enderecoDTO> enderecoDTO = enderecoService.findAll();
        return  ResponseEntity.ok(enderecoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<enderecoDTO> getById(@PathVariable Integer id){
        enderecoDTO enderecoDTO = enderecoService.findById(id);
        return ResponseEntity.ok(enderecoDTO);
    }

    @PostMapping
    public ResponseEntity<enderecoDTO> create(@Valid @RequestBody enderecoDTO enderecoDTO){
        enderecoDTO create = enderecoService.create(enderecoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PutMapping("/{id}")
    public ResponseEntity<enderecoDTO> update(@PathVariable Integer id, @Valid @RequestBody EnderecoDTO enderecoDTO){
        enderecoDTO update = enderecoService.update(id, enderecoDTO);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Valid> dalete(@PathVariable Integer id){
        enderecoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

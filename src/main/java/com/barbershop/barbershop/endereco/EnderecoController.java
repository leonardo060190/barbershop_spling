package com.barbershop.barbershop.endereco;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
@CrossOrigin(origins = " http://localhost:5173")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> getAll(){
        List<EnderecoDTO> enderecosDTO = enderecoService.findAll();
        return  ResponseEntity.ok(enderecosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> getById(@PathVariable Integer id){
        EnderecoDTO enderecoDTO = enderecoService.findById(id);
        return ResponseEntity.ok(enderecoDTO);
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> create(@Valid @RequestBody EnderecoDTO enderecoDTO){
        EnderecoDTO create = enderecoService.create(enderecoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable Integer id, @Valid @RequestBody EnderecoDTO enderecoDTO){
        EnderecoDTO update = enderecoService.update(id, enderecoDTO);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Valid> delete(@PathVariable Integer id){
        enderecoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

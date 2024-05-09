package com.barbershop.barbershop.barbearia;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barbearias")
public class BarbeariaController {

    @Autowired
    private BarbeariaService barbeariaService;

    @GetMapping
    public ResponseEntity<List<BarbeariaDTO>> getAll(){
        List<BarbeariaDTO> barbeariasDTO = barbeariaService.findAll();
        return ResponseEntity.ok(barbeariasDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarbeariaDTO> getById(@PathVariable Integer id){
        BarbeariaDTO barbeariasDTO = barbeariaService.findById(id);
        return ResponseEntity.ok(barbeariasDTO);
    }

    @PostMapping
    public ResponseEntity<BarbeariaDTO> create(@Valid @RequestBody BarbeariaDTO barbeariasDTO){
        BarbeariaDTO create = barbeariaService.create(barbeariasDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BarbeariaDTO> update(@PathVariable Integer id, @Valid @RequestBody BarbeariaDTO barbeariasDTO){
        BarbeariaDTO update= barbeariaService.update(id, barbeariasDTO);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Valid> dalete(@PathVariable Integer id){
        barbeariaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

package com.barbershop.barbershop.servico;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servico")
@CrossOrigin(origins = " http://localhost:5173")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<List<ServicoDTO>> getAll(){
        List<ServicoDTO> servicosDTO = servicoService.findAll();
        return ResponseEntity.ok(servicosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoDTO> getById(@PathVariable Integer id){
        ServicoDTO servicoDTO = servicoService.findById(id);
        return ResponseEntity.ok(servicoDTO);
    }

    @PostMapping
    public ResponseEntity<ServicoDTO> create(@Valid @RequestBody ServicoDTO servicoDTO){
        ServicoDTO create = servicoService.create(servicoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoDTO> update(@PathVariable Integer id, @Valid @RequestBody ServicoDTO servicoDTO){
        ServicoDTO update= servicoService.update(id, servicoDTO);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Valid> delete(@PathVariable Integer id){
        servicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

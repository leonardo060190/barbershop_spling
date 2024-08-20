package com.barbershop.barbershop.profissional;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissional")
@CrossOrigin(origins = " http://localhost:5173")
public class ProfissionalController {


    @Autowired
    private  ProfissionalService profissionalService;

    @GetMapping
    public ResponseEntity<List<ProfissionalDTO>> getAll(){
        List<ProfissionalDTO> profissionalDTO = profissionalService.findAll();
        return ResponseEntity.ok(profissionalDTO);
    }



    @GetMapping("/barbearia/{barbeariaId}")
    public ResponseEntity<List<ProfissionalDTO>> getBybarbeariaId(@PathVariable Integer barbeariaId) {
        List<ProfissionalDTO> profissionaisDTO = profissionalService.findByBarbeariaId(barbeariaId);
        return ResponseEntity.ok(profissionaisDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalDTO> getById(@PathVariable Integer id){
        try {
            ProfissionalDTO profissionalDTO = profissionalService.findById(id);
            return ResponseEntity.ok(profissionalDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();}
    }

    @PostMapping
    public ResponseEntity<ProfissionalDTO> create(@Valid @RequestBody ProfissionalDTO profissionalDTO){
        ProfissionalDTO create = profissionalService.create(profissionalDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProfissionalDTO> update(@PathVariable Integer id, @Valid @RequestBody ProfissionalDTO profissionalDTO){
        ProfissionalDTO update = profissionalService.update(id, profissionalDTO);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Valid> delete(@PathVariable Integer id){
        profissionalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

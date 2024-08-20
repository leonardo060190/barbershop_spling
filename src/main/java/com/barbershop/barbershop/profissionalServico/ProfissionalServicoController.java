package com.barbershop.barbershop.profissionalServico;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionalServico")
@CrossOrigin(origins = " http://localhost:5173")
public class ProfissionalServicoController {


    @Autowired
    private ProfissionalServicoService profissionalServicoService;

    @GetMapping
    public ResponseEntity<List<ProfissionalServicoDTO>> getAll(){
        List<ProfissionalServicoDTO> profissionalServicoDTO = profissionalServicoService.findAll();
        return ResponseEntity.ok(profissionalServicoDTO);
    }
    @GetMapping("/profissional/{profissionalId}")
    public ResponseEntity<List<ProfissionalServicoDTO>> getByprofissionalId(@PathVariable Integer profissionalId) {
        List<ProfissionalServicoDTO> profissionalServicoDTOS = profissionalServicoService.findByProfissionalId(profissionalId);
        return ResponseEntity.ok(profissionalServicoDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalServicoDTO> getById(@PathVariable Integer id){
        try {
            ProfissionalServicoDTO profissionalServicoDTO = profissionalServicoService.findById(id);
            return ResponseEntity.ok(profissionalServicoDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();}
    }

    @PostMapping
    public ResponseEntity<ProfissionalServicoDTO> create(@Valid @RequestBody ProfissionalServicoDTO profissionalServicoDTO){
        ProfissionalServicoDTO create = profissionalServicoService.create(profissionalServicoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProfissionalServicoDTO> update(@PathVariable Integer id, @Valid @RequestBody ProfissionalServicoDTO profissionalServicoDTO){
        ProfissionalServicoDTO update = profissionalServicoService.update(id, profissionalServicoDTO);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Valid> delete(@PathVariable Integer id){
        profissionalServicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

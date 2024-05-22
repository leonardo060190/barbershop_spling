package com.barbershop.barbershop.diaSemana;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diaSemana")
@CrossOrigin(origins = " http://localhost:5173")
public class DiaSemanaController {

    @Autowired
    private DiaSemanaService diaSemanaService;

    @GetMapping
    public ResponseEntity<List<DiaSemanaDTO>> getAllDiaSemana(){
        List<DiaSemanaDTO> diasSemanaDTO = diaSemanaService.findAll();
        return  ResponseEntity.ok(diasSemanaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiaSemanaDTO> getDiaSemanaById(@PathVariable Integer id){
        DiaSemanaDTO diaSemanaDTO = diaSemanaService.findById(id);
        return ResponseEntity.ok(diaSemanaDTO);
    }

    @PostMapping
    public ResponseEntity<DiaSemanaDTO> createDiaSemana(@Valid @RequestBody DiaSemanaDTO diaSemanaDTO){
        DiaSemanaDTO createDiaSemanaDTO = diaSemanaService.create(diaSemanaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createDiaSemanaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiaSemanaDTO> updateDiaSemana(@PathVariable Integer id, @Valid @RequestBody DiaSemanaDTO diaSemanaDTO){
        DiaSemanaDTO updateDiaSemanaDTO = diaSemanaService.update(id, diaSemanaDTO);
        return ResponseEntity.ok(updateDiaSemanaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Valid> daleteDiaSemana(@PathVariable Integer id){
        diaSemanaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

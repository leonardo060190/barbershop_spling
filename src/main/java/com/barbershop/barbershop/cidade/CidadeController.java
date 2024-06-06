package com.barbershop.barbershop.cidade;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidade")
@CrossOrigin(origins = " http://localhost:5173")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public ResponseEntity<List<CidadeDTO>> getAll(){
        List<CidadeDTO> cidadesDTO = cidadeService.findAll();
        return ResponseEntity.ok(cidadesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CidadeDTO> getById(@PathVariable Integer id){
        CidadeDTO cidadeDTO = cidadeService.findById(id);
        return ResponseEntity.ok(cidadeDTO);
    }

    @PostMapping
    public ResponseEntity<CidadeDTO> create(@Valid @RequestBody CidadeDTO cidadeDTO){
        CidadeDTO create = cidadeService.create(cidadeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CidadeDTO> update(@PathVariable Integer id, @Valid @RequestBody CidadeDTO cidadeDTO){
        CidadeDTO update= cidadeService.update(id, cidadeDTO);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Valid> delete(@PathVariable Integer id){
        cidadeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

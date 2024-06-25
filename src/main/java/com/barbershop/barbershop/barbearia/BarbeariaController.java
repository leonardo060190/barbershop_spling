package com.barbershop.barbershop.barbearia;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barbearia")
@CrossOrigin(origins = " http://localhost:5173")
public class BarbeariaController {

    @Autowired
    private BarbeariaService barbeariaService;

    @GetMapping
    public ResponseEntity<List<BarbeariaDTO>> getAll(){
        List<BarbeariaDTO> barbeariasDTO = barbeariaService.findAll();
        return ResponseEntity.ok(barbeariasDTO);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<BarbeariaDTO>> getAll(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "20") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<BarbeariaDTO> barbeariasDTO = barbeariaService.findAllPage(pageRequest);
        return ResponseEntity.ok(barbeariasDTO);
    }

    //pesquisa pelo id
    @GetMapping("/{id}")
    public ResponseEntity<BarbeariaDTO> getById(@PathVariable Integer id){
        BarbeariaDTO barbeariasDTO = barbeariaService.findById(id);
        return ResponseEntity.ok(barbeariasDTO);
    }

    //pesquisa com like
    @GetMapping("/search/{nome}")
    public ResponseEntity<List<BarbeariaDTO>> searchByName(@PathVariable String nome) {
        List<BarbeariaDTO> barbeariasDTO = barbeariaService.findByName(nome);
        return ResponseEntity.ok(barbeariasDTO);
    }



    @PostMapping
    public ResponseEntity<BarbeariaDTO> create(@Valid @RequestBody BarbeariaDTO barbeariasDTO){
        System.out.println("AKI"+barbeariasDTO);
        BarbeariaDTO create = barbeariaService.create(barbeariasDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BarbeariaDTO> update(@PathVariable Integer id, @Valid @RequestBody BarbeariaDTO barbeariasDTO){
        BarbeariaDTO update= barbeariaService.update(id, barbeariasDTO);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Valid> delete(@PathVariable Integer id){
        barbeariaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

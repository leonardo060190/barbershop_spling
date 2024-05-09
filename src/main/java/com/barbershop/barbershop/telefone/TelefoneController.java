package com.barbershop.barbershop.telefone;

import com.barbershop.barbershop.servico.ServicoDTO;
import com.barbershop.barbershop.servico.ServicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/telefone")
public class TelefoneController {

    @Autowired
    private TelefoneService telefoneService;

    @GetMapping
    public ResponseEntity<List<TelefoneDTO>> getAll(){
        List<TelefoneDTO> telefonesDTO = telefoneService.findAll();
        return ResponseEntity.ok(telefonesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelefoneDTO> getById(@PathVariable Integer id){
        TelefoneDTO telefoneDTO = telefoneService.findById(id);
        return ResponseEntity.ok(telefoneDTO);
    }

    @PostMapping
    public ResponseEntity<TelefoneDTO> create(@Valid @RequestBody TelefoneDTO telefoneDTO){
        TelefoneDTO create = telefoneService.create(telefoneDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelefoneDTO> update(@PathVariable Integer id, @Valid @RequestBody TelefoneDTO telefoneDTO){
        TelefoneDTO update= telefoneService.update(id, telefoneDTO);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Valid> dalete(@PathVariable Integer id){
        telefoneService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

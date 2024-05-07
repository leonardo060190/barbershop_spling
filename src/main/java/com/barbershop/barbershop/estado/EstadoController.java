package com.barbershop.barbershop.estado;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Habilita o REST
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping //retorna uma lista de estados
    public ResponseEntity<List<EstadoDTO>> getAllEstados(){
        List<EstadoDTO> estadosDTO = estadoService.findAll();
        return ResponseEntity.ok(estadosDTO);
    }

    @GetMapping("/{id}") //pegar por id
    public ResponseEntity<EstadoDTO> getEstadoById(@PathVariable Integer id){
        EstadoDTO estadoDTO = estadoService.findById(id);
        return ResponseEntity.ok(estadoDTO);
    }

    @PostMapping //salvar no banco
    public ResponseEntity<EstadoDTO> createEstado(@Valid @RequestBody EstadoDTO estadoDTO){
        EstadoDTO createEstadoDTO = estadoService.create(estadoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createEstadoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoDTO> updateEstado(@PathVariable Integer id, @Valid @RequestBody EstadoDTO estadoDTO){
        EstadoDTO updateEstadoDTO = estadoService.update(id, estadoDTO);
        return ResponseEntity.ok(updateEstadoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstado(@PathVariable Integer id){
        estadoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

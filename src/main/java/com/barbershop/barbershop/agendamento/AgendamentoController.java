package com.barbershop.barbershop.agendamento;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@CrossOrigin(origins = " http://localhost:5173")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping
    public ResponseEntity<List<AgendamentoDTO>> getAll(){
        List<AgendamentoDTO> agendamentosDTO = agendamentoService.findAll();
        return ResponseEntity.ok(agendamentosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> getById(@PathVariable Integer id){
        AgendamentoDTO agendamentosDTO = agendamentoService.findById(id);
        return ResponseEntity.ok(agendamentosDTO);
    }

    @PostMapping
    public ResponseEntity<AgendamentoDTO> create(@Valid @RequestBody AgendamentoDTO agendamentosDTO){
        AgendamentoDTO create = agendamentoService.create(agendamentosDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> update(@PathVariable Integer id, @Valid @RequestBody AgendamentoDTO agendamentosDTO){
        AgendamentoDTO update= agendamentoService.update(id, agendamentosDTO);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Valid> dalete(@PathVariable Integer id){
        agendamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

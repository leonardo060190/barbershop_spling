package com.barbershop.barbershop.horarioFuncionamento;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Habilita o REST
@RequestMapping("/horarioFuncionamento")
@CrossOrigin(origins = " http://localhost:5173")
public class HorarioFuncionamentoController {

    @Autowired
    private HorarioFuncionamentoService horarioFuncionamentoService;

    @GetMapping
    public ResponseEntity<List<HorarioFuncionamentoDTO>> getAll(){
        List<HorarioFuncionamentoDTO> horarioFuncionamentoDTO = horarioFuncionamentoService.findAll();
        return ResponseEntity.ok(horarioFuncionamentoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioFuncionamentoDTO> getById(@PathVariable Integer id){
        HorarioFuncionamentoDTO horarioFuncionamentoDTO = horarioFuncionamentoService.findById(id);
        return ResponseEntity.ok(horarioFuncionamentoDTO);
    }

    @PostMapping
    public ResponseEntity<HorarioFuncionamentoDTO> create(@Valid @RequestBody HorarioFuncionamentoDTO horarioFuncionamentoDTO){
        System.out.println("horario funcinamento "+horarioFuncionamentoDTO);
        HorarioFuncionamentoDTO create = horarioFuncionamentoService.create(horarioFuncionamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioFuncionamentoDTO> update(@PathVariable Integer id, @Valid @RequestBody HorarioFuncionamentoDTO horarioFuncionamentoDTO){
        HorarioFuncionamentoDTO update = horarioFuncionamentoService.update(id, horarioFuncionamentoDTO);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        horarioFuncionamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

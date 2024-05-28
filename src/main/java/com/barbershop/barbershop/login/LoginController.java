package com.barbershop.barbershop.login;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logins")
@CrossOrigin(origins = " http://localhost:5173")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    public ResponseEntity<List<LoginGetDTO>> getAll(){
        List<LoginGetDTO> loginsGetDTO = loginService.findAll();
        return ResponseEntity.ok(loginsGetDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoginGetDTO> getById(@PathVariable Integer id){
        LoginGetDTO loginGetDTO = loginService.findById(id);
        return ResponseEntity.ok(loginGetDTO);
    }

    @PostMapping
    public ResponseEntity<LoginDTO> create(@Valid @RequestBody LoginDTO loginDTO){
        LoginDTO create = loginService.create(loginDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoginDTO> update(@PathVariable Integer id, @Valid @RequestBody LoginDTO loginDTO){
        LoginDTO update= loginService.update(id, loginDTO);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Valid> dalete(@PathVariable Integer id){
        loginService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

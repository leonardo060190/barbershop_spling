package com.barbershop.barbershop.login;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = " http://localhost:5173")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    public ResponseEntity<List<LoginDTO>> getAll(){
        List<LoginDTO> loginsDTO = loginService.findAll();
        return ResponseEntity.ok(loginsDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoginDTO> getById(@PathVariable Integer id){
        LoginDTO loginDTO = loginService.findById(id);
        return ResponseEntity.ok(loginDTO);
    }

    @PostMapping
    public ResponseEntity<LoginDTO> create(@Valid @RequestBody LoginDTO loginDTO){
        System.out.println("ola" + loginDTO);
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

    @PostMapping("/authenticade")
    public ResponseEntity<LoginDTO> loginUser(@RequestBody LoginRequest loginRequest){
        LoginDTO loginDTO = loginService.loginUser(loginRequest);
        if(loginDTO == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(loginDTO);
    }


}

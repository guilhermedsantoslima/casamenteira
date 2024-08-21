package com.br.casamenteira.rest.controller;

import com.br.casamenteira.exceptions.InvalidLoginException;
import com.br.casamenteira.exceptions.NotFoundCadastroException;
import com.br.casamenteira.model.entity.LoginEntity;
import com.br.casamenteira.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) throws InvalidLoginException {
        String cpf = loginData.get("cpf");
        String senha = loginData.get("senha");

        if (service.saveLogin(cpf, senha)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login não autorizado");
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<LoginEntity> list(){
        return service.listAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<LoginEntity> getUserById(@PathVariable("id") Long id) throws NotFoundCadastroException {
        return service.getById(id);
    }
}

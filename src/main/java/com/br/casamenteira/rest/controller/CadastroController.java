package com.br.casamenteira.rest.controller;

import com.br.casamenteira.exceptions.CpfAlreadyExists;
import com.br.casamenteira.exceptions.NotFoundCadastroException;
import com.br.casamenteira.exceptions.SenhaAlreadyExists;
import com.br.casamenteira.model.DTO.CadastroDTO;
import com.br.casamenteira.model.entity.CadastroEntity;
import com.br.casamenteira.service.CadastroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private CadastroService service;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CadastroDTO criarCadastro(@RequestBody @Valid CadastroDTO cadastroDTO) throws CpfAlreadyExists, SenhaAlreadyExists {
       return service.criaCadastro(cadastroDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public CadastroDTO atualizaCadastro(@PathVariable ("id") Long id,@RequestBody @Valid CadastroDTO cadastroDTO)throws NotFoundCadastroException {
       return service.atualizaCadastro(id, cadastroDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CadastroEntity> buscarCadastroPorId(@PathVariable ("id") Long id)throws NotFoundCadastroException{
       return service.buscaPorId(id);
    }
}

package com.br.casamenteira.rest.controller;

import com.br.casamenteira.exceptions.ClothesAlreadyRentedException;
import com.br.casamenteira.exceptions.NotFoundClouthException;
import com.br.casamenteira.model.DTO.AluguelDTO;
import com.br.casamenteira.service.AluguelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {
    @Autowired
    private AluguelService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AluguelDTO fazerAluguel(@RequestBody @Valid AluguelDTO aluguelDTO)throws ClothesAlreadyRentedException, NotFoundClouthException{
        return service.alugarRoupa(aluguelDTO);
    }
}

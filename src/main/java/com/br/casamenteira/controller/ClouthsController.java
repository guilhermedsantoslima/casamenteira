package com.br.casamenteira.controller;

import com.br.casamenteira.model.DTO.ClouthDTO;
import com.br.casamenteira.service.ClouthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clouth")
public class ClouthsController {

    @Autowired
    private ClouthService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClouthDTO save(@RequestBody ClouthDTO clouthDTO){
        return service.saveClouth(clouthDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<ClouthDTO> listAll(){
        return service.list();
    }

}

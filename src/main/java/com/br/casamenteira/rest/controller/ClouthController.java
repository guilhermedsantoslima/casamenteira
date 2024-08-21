package com.br.casamenteira.rest.controller;

import com.br.casamenteira.exceptions.NotFoundClouthException;
import com.br.casamenteira.model.DTO.ClouthDTO;
import com.br.casamenteira.model.entity.ClouthEntity;
import com.br.casamenteira.service.ClouthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clouth")
public class ClouthController {

    @Autowired
    private ClouthService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClouthDTO save(@RequestBody @Valid ClouthDTO clouthDTO){
        return service.saveClouth(clouthDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<ClouthDTO> listAll(){
        return service.list();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ClouthEntity> getById(@PathVariable ("id") Long id)throws NotFoundClouthException{
        return service.getById(id);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ClouthDTO patchUpdate(@PathVariable ("id") Long id, @RequestBody @Valid ClouthDTO clouthDTO)throws NotFoundClouthException {
        return service.UpdateAttribute(id, clouthDTO);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClouth(@PathVariable ("id") @Valid Long id)throws NotFoundClouthException{
        service.delete(id);
    }

}

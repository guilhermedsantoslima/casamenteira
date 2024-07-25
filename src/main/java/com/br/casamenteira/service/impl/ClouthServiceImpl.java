package com.br.casamenteira.service.impl;

import com.br.casamenteira.model.DTO.ClouthDTO;
import com.br.casamenteira.model.entity.ClouthEntity;
import com.br.casamenteira.repository.ClouthRepository;
import com.br.casamenteira.service.ClouthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClouthServiceImpl implements ClouthService {

    @Autowired
    private ClouthRepository repository;
    @Override
    public ClouthDTO saveClouth(ClouthDTO clouthDTO) {
        ClouthEntity clouthEntity = new ClouthEntity();

        clouthEntity.setCor(clouthDTO.getCor());
        clouthEntity.setDescricao(clouthDTO.getDescricao());
        clouthEntity.setPreco(clouthDTO.getPreco());
        clouthEntity.setTipoDaRoupa(clouthDTO.getTipoDaRoupa());

        repository.save(clouthEntity);

        return clouthDTO;
    }

    @Override
    public List<ClouthDTO> list() {
        List<ClouthEntity> clouthEntities = repository.findAll();
        List<ClouthDTO> clouthDTOS = new ArrayList<>();

        clouthEntities.forEach(c ->{
            ClouthDTO clouthDTO = new ClouthDTO();

            clouthDTO.setCor(c.getCor());
            clouthDTO.setDescricao(c.getDescricao());
            clouthDTO.setPreco(c.getPreco());
            clouthDTO.setTipoDaRoupa(c.getTipoDaRoupa());

            clouthDTOS.add(clouthDTO);
        });
        return clouthDTOS;
    }
}

package com.br.casamenteira.service;

import com.br.casamenteira.exceptions.NotFoundClouthException;
import com.br.casamenteira.model.DTO.ClouthDTO;
import com.br.casamenteira.model.entity.ClouthEntity;

import java.util.List;
import java.util.Optional;

public interface ClouthService {

    ClouthDTO saveClouth(ClouthDTO clouthDTO);
    List<ClouthDTO> list();
    Optional<ClouthEntity> getById(Long id)throws NotFoundClouthException;
    ClouthDTO UpdateAttribute(Long id, ClouthDTO clouthDTO) throws NotFoundClouthException;
    void delete(Long id) throws NotFoundClouthException;
}

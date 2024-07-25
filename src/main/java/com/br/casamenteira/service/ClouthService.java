package com.br.casamenteira.service;

import com.br.casamenteira.model.DTO.ClouthDTO;

import java.util.List;

public interface ClouthService {

    ClouthDTO saveClouth(ClouthDTO clouthDTO);

    List<ClouthDTO> list();
}

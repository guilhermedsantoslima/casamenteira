package com.br.casamenteira.service;

import com.br.casamenteira.exceptions.ClothesAlreadyRentedException;
import com.br.casamenteira.exceptions.NotFoundClouthException;
import com.br.casamenteira.model.DTO.AluguelDTO;

public interface AluguelService {

    AluguelDTO alugarRoupa(AluguelDTO aluguelDTO)throws ClothesAlreadyRentedException, NotFoundClouthException;
}

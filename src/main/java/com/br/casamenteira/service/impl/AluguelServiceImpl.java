package com.br.casamenteira.service.impl;

import com.br.casamenteira.exceptions.ClothesAlreadyRentedException;
import com.br.casamenteira.exceptions.NotFoundClouthException;
import com.br.casamenteira.model.DTO.AluguelDTO;
import com.br.casamenteira.model.entity.AluguelEntity;
import com.br.casamenteira.model.entity.ClouthEntity;
import com.br.casamenteira.repository.AluguelRepository;
import com.br.casamenteira.repository.ClouthRepository;
import com.br.casamenteira.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AluguelServiceImpl implements AluguelService {
    @Autowired
    private ClouthRepository clouthRepository;
    @Autowired
    private AluguelRepository aluguelRepository;
    @Override
    public AluguelDTO alugarRoupa(AluguelDTO aluguelDTO) throws ClothesAlreadyRentedException, NotFoundClouthException {
        Optional<ClouthEntity> clouth = clouthRepository.findById(aluguelDTO.getCodigoDaRoupa());

        if (!clouth.isPresent()){
            throw new NotFoundClouthException();
        }

        AluguelEntity roupaAlugada = aluguelRepository.findByDataAluguelAndCodigoDaRoupa
                (aluguelDTO.getDataAluguel(), aluguelDTO.getCodigoDaRoupa());

        if (roupaAlugada != null && roupaAlugada.getCodigoDaRoupa().equals(aluguelDTO.getCodigoDaRoupa())){
            throw new ClothesAlreadyRentedException();
        }

        AluguelEntity aluguelEntity = new AluguelEntity();

        aluguelEntity.setCodigoDaRoupa(aluguelDTO.getCodigoDaRoupa());
        aluguelEntity.setDataAluguel(aluguelDTO.getDataAluguel());
        aluguelEntity.setDataDevolucao(aluguelDTO.getDataDevolucao());

        aluguelRepository.save(aluguelEntity);

        return aluguelDTO;
    }
}

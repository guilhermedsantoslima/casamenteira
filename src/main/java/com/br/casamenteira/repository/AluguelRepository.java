package com.br.casamenteira.repository;

import com.br.casamenteira.model.entity.AluguelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface AluguelRepository extends JpaRepository<AluguelEntity, Long> {

    AluguelEntity findByDataAluguelAndCodigoDaRoupa(LocalDate dataAluguel, Long codigoDaRoupa);
}

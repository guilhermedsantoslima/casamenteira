package com.br.casamenteira.service;

import com.br.casamenteira.exceptions.CpfAlreadyExists;
import com.br.casamenteira.exceptions.NotFoundCadastroException;
import com.br.casamenteira.exceptions.SenhaAlreadyExists;
import com.br.casamenteira.model.DTO.CadastroDTO;
import com.br.casamenteira.model.entity.CadastroEntity;

import java.util.Optional;

public interface CadastroService {

    CadastroDTO criaCadastro(CadastroDTO cadastroDTO)throws CpfAlreadyExists, SenhaAlreadyExists;
    CadastroDTO atualizaCadastro(Long id, CadastroDTO cadastroDTO)throws NotFoundCadastroException;
    Optional<CadastroEntity> buscaPorId(Long id) throws NotFoundCadastroException;
}

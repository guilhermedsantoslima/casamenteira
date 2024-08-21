package com.br.casamenteira.service;

import com.br.casamenteira.exceptions.InvalidLoginException;
import com.br.casamenteira.exceptions.NotFoundCadastroException;
import com.br.casamenteira.model.entity.LoginEntity;

import java.util.List;
import java.util.Optional;

public interface LoginService {

    boolean saveLogin(String cpf, String senha)throws InvalidLoginException;
    List<LoginEntity> listAll();
    Optional<LoginEntity> getById(Long id)throws NotFoundCadastroException;

}

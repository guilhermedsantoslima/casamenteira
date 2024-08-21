package com.br.casamenteira.service.impl;

import com.br.casamenteira.exceptions.InvalidLoginException;
import com.br.casamenteira.exceptions.NotFoundCadastroException;
import com.br.casamenteira.model.entity.CadastroEntity;
import com.br.casamenteira.model.entity.LoginEntity;
import com.br.casamenteira.repository.CadastroRepository;
import com.br.casamenteira.repository.LoginRepository;
import com.br.casamenteira.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private CadastroRepository cadastroRepository;
    @Autowired
    private LoginRepository loginRepository;

    public boolean saveLogin(String cpf, String senha)throws InvalidLoginException {
        CadastroEntity cadastro = cadastroRepository.findByCpf(cpf);

        if(cadastro != null && cadastro.getSenha().equals(senha)){
            LoginEntity loginUser = new LoginEntity();

            loginUser.setIdUsuario(cadastro.getId());
            loginUser.setCpf(cadastro.getCpf());
            loginUser.setSenha(cadastro.getSenha());

            loginRepository.save(loginUser);
            return true;
        }
        else{
            throw new InvalidLoginException();
        }
    }

    public List<LoginEntity> listAll() {
        List<LoginEntity> loginEntities = loginRepository.findAll();
        return loginEntities;
    }

    public Optional<LoginEntity> getById(Long id)throws NotFoundCadastroException {
        Optional<LoginEntity> loginEntities = loginRepository.findById(id);

        if(!loginEntities.isPresent()){
            throw new NotFoundCadastroException();
        }
        return loginRepository.findById(id);
    }
}

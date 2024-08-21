package com.br.casamenteira.service.impl;

import com.br.casamenteira.exceptions.CpfAlreadyExists;
import com.br.casamenteira.exceptions.NotFoundCadastroException;
import com.br.casamenteira.exceptions.SenhaAlreadyExists;
import com.br.casamenteira.model.DTO.CadastroDTO;
import com.br.casamenteira.model.entity.CadastroEntity;
import com.br.casamenteira.repository.CadastroRepository;
import com.br.casamenteira.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroServiceImpl implements CadastroService {

    @Autowired
    private CadastroRepository cadastroRepository;
    @Override
    public CadastroDTO criaCadastro(CadastroDTO cadastroDTO)throws CpfAlreadyExists, SenhaAlreadyExists {
        CadastroEntity cadastroCpf = cadastroRepository.findByCpf(cadastroDTO.getCpf());
        if (cadastroCpf != null){
            throw new CpfAlreadyExists();
        }

        CadastroEntity cadastroSenha = cadastroRepository.findBySenha(cadastroDTO.getSenha());
        if(cadastroSenha != null){
            throw new SenhaAlreadyExists();
        }

        CadastroEntity cadastroEntity = new CadastroEntity();

        cadastroEntity.setNomeCompleto(cadastroDTO.getNomeCompleto());
        cadastroEntity.setCpf(cadastroDTO.getCpf());
        cadastroEntity.setSenha(cadastroDTO.getSenha());

        cadastroRepository.save(cadastroEntity);

        return cadastroDTO;
    }

    @Override
    public CadastroDTO atualizaCadastro(Long id, CadastroDTO cadastroDTO)throws NotFoundCadastroException {
        Optional<CadastroEntity> cadastros = cadastroRepository.findById(id);

        if (!cadastros.isPresent()){
            throw new NotFoundCadastroException();
        }

        CadastroEntity cadastroEntity = cadastros.get();

        if(cadastroDTO.getSenha() != null){
            cadastroEntity.setSenha(cadastroDTO.getSenha());
        }

        cadastroRepository.save(cadastroEntity);

        return cadastroDTO;
    }

    @Override
    public Optional<CadastroEntity> buscaPorId(Long id)throws NotFoundCadastroException {
        Optional<CadastroEntity> cadastroEntity = cadastroRepository.findById(id);

        if (!cadastroEntity.isPresent()){
            throw new NotFoundCadastroException();
        }

        return cadastroRepository.findById(id);
    }
}

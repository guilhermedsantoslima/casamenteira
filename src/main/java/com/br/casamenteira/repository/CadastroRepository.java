package com.br.casamenteira.repository;

import com.br.casamenteira.model.entity.CadastroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroRepository extends JpaRepository<CadastroEntity, Long> {
    CadastroEntity findByCpf(String cpf);
    CadastroEntity findBySenha(String senha);
}

package com.br.casamenteira.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClouthDTO {

    private String cor;
    private String descricao;
    private BigDecimal preco;
    private String tipoDaRoupa;
}

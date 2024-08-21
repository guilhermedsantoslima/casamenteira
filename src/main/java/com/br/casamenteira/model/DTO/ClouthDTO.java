package com.br.casamenteira.model.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotEmpty(message = "{campo.cor.obrigatorio}")
    private String cor;

    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;

    @NotNull(message = "{campo.preco.obrigatorio}")
    @DecimalMin(value = "0.01", message = "{campo.preco.minimo}")
    private BigDecimal preco;

    @NotEmpty(message = "{campo.tipoDaRoupa.obrigatorio}")
    private String tipoDaRoupa;
}

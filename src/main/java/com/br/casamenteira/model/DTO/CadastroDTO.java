package com.br.casamenteira.model.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CadastroDTO {

    @NotEmpty(message = "{campo.nomeCompleto.obrigatorio}")
    private String nomeCompleto;

    @NotEmpty(message = "{campo.cpf.obrigatorio}")
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$", message = "{campo.cpf.invalido}")
    private String cpf;

    @NotEmpty(message = "{campo.senha.obrigatorio}")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$",
            message = "{campo.senha.invalido}")
    private String senha;
}

package com.br.casamenteira.exceptions;

public class NotFoundCadastroException extends Exception{
    public NotFoundCadastroException() {
        super("Cadastro nâo encontrado");
    }
}

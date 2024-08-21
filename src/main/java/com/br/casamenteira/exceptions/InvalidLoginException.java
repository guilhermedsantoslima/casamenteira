package com.br.casamenteira.exceptions;

public class InvalidLoginException extends Exception{
    public InvalidLoginException() {
        super("Login inválido");
    }
}

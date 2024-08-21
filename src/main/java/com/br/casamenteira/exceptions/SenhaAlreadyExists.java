package com.br.casamenteira.exceptions;

public class SenhaAlreadyExists extends Exception{
    public SenhaAlreadyExists() {
        super("Essa senha já existe");
    }
}

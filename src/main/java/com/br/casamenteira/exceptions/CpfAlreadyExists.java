package com.br.casamenteira.exceptions;

public class CpfAlreadyExists extends Exception{
    public CpfAlreadyExists() {
        super("Esse cpf já existe");
    }
}

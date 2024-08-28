package com.br.casamenteira.exceptions;

public class ClothesAlreadyRentedException extends Exception{
    public ClothesAlreadyRentedException() {
        super("Essa roupa já está alugada");
    }
}

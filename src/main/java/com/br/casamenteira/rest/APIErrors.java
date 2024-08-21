package com.br.casamenteira.rest;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class APIErrors {

    @Getter
    private List<String> errors;

    public APIErrors(String errorMessage){
        this.errors = Arrays.asList(errorMessage);
    }

    public APIErrors(List<String> errors) {
        this.errors = errors;
    }
}

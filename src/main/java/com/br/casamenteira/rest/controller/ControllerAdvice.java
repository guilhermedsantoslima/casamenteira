package com.br.casamenteira.rest.controller;

import com.br.casamenteira.exceptions.*;
import com.br.casamenteira.rest.APIErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public APIErrors handleMethodValidNotException(MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult().getAllErrors()
                .stream()
                .map(e -> e.getDefaultMessage())
                .collect(Collectors.toList());

        return new APIErrors(errors);
    }
    @ExceptionHandler(NotFoundClouthException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public APIErrors handleNotFoundClouthException(NotFoundClouthException e){
        return new APIErrors(e.getMessage());
    }

    @ExceptionHandler(NotFoundCadastroException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public APIErrors handleNotFoundCadastroException(NotFoundCadastroException e){
        return new APIErrors(e.getMessage());
    }

    @ExceptionHandler(InvalidLoginException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public APIErrors handleInvalidLoginException(InvalidLoginException e){
        return new APIErrors(e.getMessage());
    }

    @ExceptionHandler(CpfAlreadyExists.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public APIErrors handleCpfAlreadyExists(CpfAlreadyExists e){
        return new APIErrors(e.getMessage());
    }

    @ExceptionHandler(SenhaAlreadyExists.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public APIErrors handleSenhaAlreadyExists(SenhaAlreadyExists e){
        return new APIErrors(e.getMessage());
    }
}

package com.br.appointements.exceptions;

public class BusinessException extends RuntimeException {
    public BusinessException(){super("cpf or email already exists in the database");}

    public BusinessException(String message){super(message);}
}
package com.mazin.cursinho.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    //constructor that accepts a resource id and passes a message to the superclass
    public ResourceNotFoundException(Object id) {
        super("Recurso nao encontrado. Id: " + id);
    }
    
}

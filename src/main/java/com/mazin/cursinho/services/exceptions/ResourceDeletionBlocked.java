package com.mazin.cursinho.services.exceptions;

//import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

public class ResourceDeletionBlocked extends DataIntegrityViolationException{
    private static final long serialVersionUID = 1L;

    //constructor that accepts a resource id and passes a message to the superclass
    public ResourceDeletionBlocked(Object id) {
        super("Recurso nao pode ser excluido. Id: " + id);
    }
    
}

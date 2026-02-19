package com.mazin.cursinho.resources.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.mazin.cursinho.services.exceptions.ResourceNotFoundException;
import com.mazin.cursinho.services.exceptions.ResourceDeletionBlocked;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice //indicates that this class will handle exceptions globally
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) //specifies the exception this method will handle
    public ResponseEntity<StardandError> resourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {

        String error = "Recurso nao encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND; 
        StardandError err = new StardandError(Instant.now(),status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ResourceDeletionBlocked.class) //handles constraint violation when deleting protected resources
    public ResponseEntity<StardandError> resourceDeletionBlocked(ResourceDeletionBlocked e, HttpServletRequest request) {

        String error = "Erro ao deletar recurso";
        HttpStatus status = HttpStatus.CONFLICT; // 409 Conflict - appropriate for constraint violations
        StardandError err = new StardandError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}

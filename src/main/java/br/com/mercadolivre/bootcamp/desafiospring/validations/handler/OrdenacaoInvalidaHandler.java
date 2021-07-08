package br.com.mercadolivre.bootcamp.desafiospring.validations.handler;

import br.com.mercadolivre.bootcamp.desafiospring.validations.exception.OrdenacaoInvalidaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrdenacaoInvalidaHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(OrdenacaoInvalidaException.class)
    public ResponseEntity<?> handleOrdenacaoInvalidaException(OrdenacaoInvalidaException exception){
        return ResponseEntity.badRequest().build();
    }
}

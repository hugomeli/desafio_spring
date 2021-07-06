package br.com.mercadolivre.bootcamp.desafiospring.validations.handler;

import br.com.mercadolivre.bootcamp.desafiospring.validations.exception.VendedorInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class VendedorInvalidoHandler {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(VendedorInvalidoException.class)
    public ResponseEntity<?> handleVendedorInvalidoException(VendedorInvalidoException exception){
        return ResponseEntity.notFound().build();
    }
}

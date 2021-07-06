package br.com.mercadolivre.bootcamp.desafiospring.validations.handler;

import br.com.mercadolivre.bootcamp.desafiospring.validations.exception.UsuarioInvalidoException;
import br.com.mercadolivre.bootcamp.desafiospring.validations.exception.VendedorInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UsuarioInvalidoHandler {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(UsuarioInvalidoException.class)
    public ResponseEntity<?> handleUsuarioInvalidoException(UsuarioInvalidoException exception){
        return ResponseEntity.notFound().build();
    }
}

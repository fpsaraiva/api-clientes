package dev.fpsaraiva.apiclientes.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestControllerAdvice
public class HandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroPadronizado> handle(MethodArgumentNotValidException methodArgumentNotValidException) {
        Collection<String> mensagens = new ArrayList<>();
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        fieldErrors.forEach(fieldError -> {
            //Mensagem original, antes da alteração para teste no frontend (formulario cadastro usuario)
            //String message = String.format("Campo %s %s", fieldError.getField(), fieldError.getDefaultMessage());
            String message = String.format(fieldError.getDefaultMessage());
            mensagens.add(message);
        });

        ErroPadronizado erroPadronizado = new ErroPadronizado(mensagens);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroPadronizado);
    }

    @ExceptionHandler(ApiErroException.class)
    public ResponseEntity<ErroPadronizado> handleApiErroException(ApiErroException apiErroException) {
        Collection<String> mensagens = new ArrayList<>();
        mensagens.add(apiErroException.getReason());

        ErroPadronizado erroPadronizado = new ErroPadronizado(mensagens);
        return ResponseEntity.status(apiErroException.getHttpStatus()).body(erroPadronizado);
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<ErroPadronizado> handleApiErroException(InvalidFormatException invalidFormatException) {
        Collection<String> mensagens = new ArrayList<>();
        mensagens.add("ERRO no tipo de telefone informado! Os tipos disponíveis para registro são: CELULAR, COMERCIAL, RESIDENCIAL.");

        ErroPadronizado erroPadronizado = new ErroPadronizado(mensagens);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroPadronizado);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity handleResponseStatusException(ResponseStatusException ex) {
        Collection<String> mensagens = new ArrayList<>();
        mensagens.add(ex.getReason());
        HttpStatus codigoStatus = ex.getStatus();
        ErroPadronizado erroPadronizado = new ErroPadronizado(mensagens);
        return new ResponseEntity(erroPadronizado, codigoStatus);
    }
}

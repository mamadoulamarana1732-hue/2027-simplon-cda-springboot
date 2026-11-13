package fr.simplon.domedespuys.controller_advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class NumberFormatExceptionResponse {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ExceptionResponse getResponse(NumberFormatException e) {
        return new ExceptionResponse(
                "La requête n'est pas correctement formatée",
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name()
        );
    }
}
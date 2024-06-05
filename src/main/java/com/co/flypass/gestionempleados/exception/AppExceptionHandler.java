package com.co.flypass.gestionempleados.exception;

import com.co.flypass.gestionempleados.controller.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<Object> exceptionHandler(AppException exception) {

        if(exception instanceof NoDataFoundException){
            return buildResponseEntity(new Response<>(HttpStatus.NOT_FOUND.value(), exception.getExceptionMessage()), HttpStatus.NOT_FOUND);
        }
        return buildResponseEntity(new Response<>(HttpStatus.BAD_REQUEST.value(), exception.getExceptionMessage()), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<Object> buildResponseEntity(Response<Void> responseObject, HttpStatus status) {
        return new ResponseEntity<>(responseObject, status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> exceptionHandlerBean(MethodArgumentNotValidException exception) {

         List<String> errors = exception.getBindingResult().getFieldErrors()
                .stream()
                .map(x -> x.getField() + " " + x.getDefaultMessage())
                .collect(Collectors.toList());

        return buildResponseEntity(new Response<>(new BadRequestException(errors)), HttpStatus.BAD_REQUEST);
    }
}

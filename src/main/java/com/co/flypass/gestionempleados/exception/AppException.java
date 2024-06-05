package com.co.flypass.gestionempleados.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.List;

@RestControllerAdvice
public class AppException extends Exception {

    private String msg;

    public AppException(){
        super();
    }

    public AppException(String msg){
        super(msg);
        this.msg = msg;
    }

    public String getExceptionMessage() {
        return this.msg != null ? this.msg : "Error procesando su solicitud";
    }

}

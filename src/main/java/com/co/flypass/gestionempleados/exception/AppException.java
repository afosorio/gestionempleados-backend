package com.co.flypass.gestionempleados.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppException extends Exception {

    private String msg;

    private String code;

    public AppException() {
    }

    public AppException(String code, String msg, Throwable err){
        super(msg, err);
        this.msg = msg;
        this.code = code;
    }

    public AppException(String code, String msg){
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public AppException(String msg){
        super(msg);
        this.msg = msg;
    }

    public String getExceptionMessage() {
        return this.msg != null ? this.msg : "Error procesando su solicitud";
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }
}

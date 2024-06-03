package com.co.flypass.gestionempleados.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppException extends Exception {

    private String msg;

    private String code;

    public AppException() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getExceptionMessage() {
        return this.msg != null ? this.msg : "Error procesando su solicitud";
    }

}

package com.co.flypass.gestionempleados.controller;


import com.co.flypass.gestionempleados.exception.BadRequestException;

import java.util.List;

public class Response<T> {
    private T body;
    private int httpCode;
    private String message;
    private List<String> errors;

    public Response(int httpCode, String message) {
        this.httpCode = httpCode;
        this.message = message;
    }

    public Response(int httpCode, String message, T body) {
        this.httpCode = httpCode;
        this.message = message;
        this.body = body;
    }

    public Response(BadRequestException e) {
        this.httpCode = e.getStatus().value();
        this.message = e.getMessage();
        this.errors = e.getErrors();
    }

    public Response(int httpCode) {
        this.httpCode = httpCode;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public T getBody() {
        return body;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}

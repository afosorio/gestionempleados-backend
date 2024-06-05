package com.co.flypass.gestionempleados.exception;

public class NoDataFoundException extends AppException {

    public NoDataFoundException(String code, String message, Throwable err) {
        super(code, message, err);
    }

    public NoDataFoundException(String code, String message) {
        super(code, message);
    }

    public NoDataFoundException(String message) {
        super(message);
    }
}

package br.com.cleonildo.core.exceptions;

public class EmailServiceException extends RuntimeException {
    public EmailServiceException(String message) {
        super(message);
    }

    public EmailServiceException(String messsage, Throwable cause) {
        super(messsage, cause);
    }
}

package edu.mum.cs544.exceptions;

public class BadRequestException extends AbstractException {

    public BadRequestException(String code, String message) {
        super(code, message);
    }
}
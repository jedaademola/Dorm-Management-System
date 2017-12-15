package edu.mum.cs544.exceptions;

public class NotFoundException extends AbstractException {

    public NotFoundException(String code, String message) {
        super(code, message);
    }
}

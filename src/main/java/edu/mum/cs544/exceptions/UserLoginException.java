package edu.mum.cs544.exceptions;


public class UserLoginException extends AbstractException {

    public UserLoginException(String code, String message) {
        super(code, message);
    }
}

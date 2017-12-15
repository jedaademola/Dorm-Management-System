package edu.mum.cs544.exceptions;


public class AbstractException extends RuntimeException {

    private String code;


    public AbstractException(String code, String message) {

        super(message);
        this.setCode(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

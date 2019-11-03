package com.homework.chassetresore.exception;

public class GenericException extends Exception {

    private String code;
    private String message;

    public GenericException(String code, String message) {
        super(String.join(" : ", code, message));
        this.code = code;
        this.message = message;
    }
}

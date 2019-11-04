package com.homework.chassetresore.exception;

public class AventurierOrBordureException extends Exception {

    public AventurierOrBordureException(String message) {
        super(String.join(ExceptionEnum.ERROR_FILE_09.getCode(), message));
    }
}

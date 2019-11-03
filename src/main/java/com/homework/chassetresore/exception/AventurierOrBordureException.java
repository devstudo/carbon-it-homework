package com.homework.chassetresore.exception;

public class AventurierOrBordureException extends GenericException {

    public AventurierOrBordureException(String message) {
        super(ExceptionEnum.ERROR_FILE_09.getCode(), message);
    }
}

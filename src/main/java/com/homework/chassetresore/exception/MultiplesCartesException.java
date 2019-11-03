package com.homework.chassetresore.exception;

public class MultiplesCartesException extends GenericException {

    public MultiplesCartesException() {
        super(ExceptionEnum.ERROR_FILE_02.getCode(), ExceptionEnum.ERROR_FILE_02.getMessage());
    }
}

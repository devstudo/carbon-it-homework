package com.homework.chassetresore.exception;

public class TresorNonConformeException extends GenericException {

    public TresorNonConformeException() {
        super(ExceptionEnum.ERROR_FILE_04.getCode(), ExceptionEnum.ERROR_FILE_04.getMessage());
    }
}

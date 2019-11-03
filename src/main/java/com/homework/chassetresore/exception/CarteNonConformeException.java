package com.homework.chassetresore.exception;

public class CarteNonConformeException extends GenericException {

    public CarteNonConformeException() {
        super(ExceptionEnum.ERROR_FILE_01.getCode(), ExceptionEnum.ERROR_FILE_01.getMessage());
    }
}

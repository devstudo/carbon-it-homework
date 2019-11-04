package com.homework.chassetresore.exception;

public class CarteNonConformeException extends Exception {

    public CarteNonConformeException() {
        super(String.join(ExceptionEnum.ERROR_FILE_01.getCode(), ExceptionEnum.ERROR_FILE_01.getMessage()));
    }
}

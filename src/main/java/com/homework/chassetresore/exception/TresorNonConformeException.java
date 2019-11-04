package com.homework.chassetresore.exception;

public class TresorNonConformeException extends Exception {

    public TresorNonConformeException() {
        super(ExceptionEnum.ERROR_FILE_04.toString());
    }
}

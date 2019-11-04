package com.homework.chassetresore.exception;

public class MontagneNonConformeException extends Exception {

    public MontagneNonConformeException() {
        super(ExceptionEnum.ERROR_FILE_03.toString());
    }
}

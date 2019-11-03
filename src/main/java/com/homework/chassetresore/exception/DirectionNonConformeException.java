package com.homework.chassetresore.exception;

public class DirectionNonConformeException extends IllegalStateException {

    public DirectionNonConformeException() {
        super(ExceptionEnum.ERROR_FILE_06.toString());
    }
}

package com.homework.chassetresore.exception;

public class AventurierHorsBordureException extends Exception {

    public AventurierHorsBordureException(String message) {
        super(String.join(ExceptionEnum.ERROR_FILE_09.getCode(), message));
    }
}

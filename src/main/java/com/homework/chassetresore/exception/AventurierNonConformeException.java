package com.homework.chassetresore.exception;

public class AventurierNonConformeException extends Exception {
    public AventurierNonConformeException() {
        super(ExceptionEnum.ERROR_FILE_05.toString());
    }
}

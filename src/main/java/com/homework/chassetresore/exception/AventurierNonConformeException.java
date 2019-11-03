package com.homework.chassetresore.exception;

public class AventurierNonConformeException extends GenericException {
    public AventurierNonConformeException() {
        super(ExceptionEnum.ERROR_FILE_05.getCode(), ExceptionEnum.ERROR_FILE_05.getMessage());
    }
}

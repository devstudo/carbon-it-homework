package com.homework.chassetresore.exception;

public class MotagneNonConformeException extends GenericException {

    public MotagneNonConformeException() {
        super(ExceptionEnum.ERROR_FILE_03.getCode() , ExceptionEnum.ERROR_FILE_03.getMessage());
    }
}

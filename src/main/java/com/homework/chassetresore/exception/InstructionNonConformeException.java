package com.homework.chassetresore.exception;

public class InstructionNonConformeException extends IllegalStateException {

    public InstructionNonConformeException() {
        super(ExceptionEnum.ERROR_FILE_07.toString());
    }
}

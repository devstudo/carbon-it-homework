package com.homework.chassetresore.exception;

public class ItemdeCarteNonConformeException extends IllegalStateException {

    public ItemdeCarteNonConformeException() {
        super(ExceptionEnum.ERROR_FILE_08.toString());
    }
}

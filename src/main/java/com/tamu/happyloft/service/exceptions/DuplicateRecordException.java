package com.tamu.happyloft.service.exceptions;

/**
 * Created by bgowda on 09/03/17.
 */
public class DuplicateRecordException extends RuntimeException {

    public DuplicateRecordException(String errorMessage) {
        super(errorMessage);
    }
}

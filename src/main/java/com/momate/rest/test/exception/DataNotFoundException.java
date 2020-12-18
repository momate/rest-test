package com.momate.rest.test.exception;

public class DataNotFoundException extends RuntimeException {

    static final long serialVersionUID = -6L;

    public DataNotFoundException(String message) {
        super(message);
    }

}

package com.gregory.parkingmeter.domain.exception;

public class DataNullOrEmptyException extends RuntimeException {
    public DataNullOrEmptyException(String message) {
        super(message);
    }
}

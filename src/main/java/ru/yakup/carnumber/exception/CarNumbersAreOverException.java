package ru.yakup.carnumber.exception;

import org.springframework.core.NestedRuntimeException;

public class CarNumbersAreOverException extends NestedRuntimeException {

    private static final String MESSAGE_ERROR = "CAR NUMBERS ARE OVER!";

    public CarNumbersAreOverException() {
        super(MESSAGE_ERROR);
    }
}
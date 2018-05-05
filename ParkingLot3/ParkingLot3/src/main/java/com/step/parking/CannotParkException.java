package com.step.parking;

public class CannotParkException extends Throwable {
    public CannotParkException(String message) {
        super(message);
    }
}

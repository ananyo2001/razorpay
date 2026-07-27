package com.ananyo.razorpay.common.exception;

public class InvalidStatetransitionException extends RuntimeException {

    private final String fromState;
    private final String event;

    public InvalidStatetransitionException(String fromState, String event) {
        super("Invalid transition from " + fromState + " with event " + event);
        this.fromState = fromState;
        this.event = event;
    }
}

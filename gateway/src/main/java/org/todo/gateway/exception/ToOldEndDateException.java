package org.todo.gateway.exception;

public class ToOldEndDateException extends RuntimeException {
    public ToOldEndDateException(String message) {
        super(message);
    }
}

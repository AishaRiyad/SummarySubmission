package org.example;

public class NullOrEmptyException extends RuntimeException{
    public NullOrEmptyException(String errorMessage) {
        super(errorMessage);
    }
}

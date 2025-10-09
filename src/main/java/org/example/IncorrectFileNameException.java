package org.example;

public class IncorrectFileNameException extends Exception{
    public IncorrectFileNameException(String errorMessage) {
        super(errorMessage);
    }
}

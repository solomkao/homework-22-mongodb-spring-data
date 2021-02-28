package com.solomka.exceptions;

public class AlarmNotFoundException extends RuntimeException {

    private static String message = "There's no such alarm";

    public AlarmNotFoundException(){
        super(message);
    }
}

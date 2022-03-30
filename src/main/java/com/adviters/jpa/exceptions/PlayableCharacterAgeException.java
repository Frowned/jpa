package com.adviters.jpa.exceptions;

public class PlayableCharacterAgeException extends Exception {
    public PlayableCharacterAgeException() {
        super("La edad no es válida");
    }
    public PlayableCharacterAgeException(String errorMessage) {
        super(errorMessage);
    }
}

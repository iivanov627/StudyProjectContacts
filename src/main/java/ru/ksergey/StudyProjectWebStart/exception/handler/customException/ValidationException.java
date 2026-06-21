package ru.ksergey.StudyProjectWebStart.exception.handler.customException;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}

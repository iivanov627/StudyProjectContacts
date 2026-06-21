package ru.ksergey.StudyProjectWebStart.exception.handler.customException;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }

}

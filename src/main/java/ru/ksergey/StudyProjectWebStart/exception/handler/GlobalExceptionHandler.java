package ru.ksergey.StudyProjectWebStart.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import ru.ksergey.StudyProjectWebStart.common.util.ServerResponseHelper;
import ru.ksergey.StudyProjectWebStart.exception.handler.customException.EntityNotFoundException;
import ru.ksergey.StudyProjectWebStart.exception.handler.customException.ValidationException;
import ru.ksergey.StudyProjectWebStart.model.ServerResponse;

import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ServerResponse<Void>> handleValidationException(
            MethodArgumentNotValidException ex
    ){
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> String.format("%s: %s",
                        error.getField(), error.getDefaultMessage()))
                .toList();

        return ServerResponseHelper.conflict(errors);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ServerResponse<Void>> handleUuidException(
            MethodArgumentTypeMismatchException ex
    ){
        return ServerResponseHelper.conflict(Collections
                .singletonList(String.format("Неверно указано значение %s", ex.getName())));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ServerResponse<Void>> handleEntityNotFound(
            EntityNotFoundException ex
    ){
        return ServerResponseHelper.notFound(
                Collections.singletonList(ex.getMessage()));
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ServerResponse<Void>> handleValidationException (
            ValidationException ex
    ){
        return ServerResponseHelper.conflict(
                Collections.singletonList(ex.getMessage()));
    }

}

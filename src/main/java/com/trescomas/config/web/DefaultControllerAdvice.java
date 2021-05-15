package com.trescomas.config.web;

import com.trescomas.exception.ResourceNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ValidationException;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@ControllerAdvice
public class DefaultControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return buildObjectErrorsMap(ex.getBindingResult().getAllErrors());
    }

    @ResponseBody
    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex) {
        return buildDefaultMessageMap(ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return buildDefaultMessageMap(ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Map<String, String> handleValidationException(ValidationException ex) {
        return buildDefaultMessageMap(ex.getMessage());
    }

    /**
     * Builds a Map where key is a constant and value is given error message
     *
     * @param message - detailed error message
     * @return Map where key is a constant and value is given error message
     */
    private Map<String, String> buildDefaultMessageMap(String message) {
        final var MESSAGE_KEY = "message";
        return Map.of(MESSAGE_KEY, message);
    }

    /**
     * Builds a Map where key is name of failed field and value is a default message
     *
     * @param objectErrors - Collection that contains objectErrors
     * @return Map where key is name of failed field and value is a default message
     */
    private Map<String, String> buildObjectErrorsMap(Collection<ObjectError> objectErrors) {
        return objectErrors.stream()
                .collect(Collectors.toMap(
                        objectError -> ((FieldError) objectError).getField(),
                        objectError -> Optional.of(objectError.getObjectName()).orElse(""))
                );
    }

}

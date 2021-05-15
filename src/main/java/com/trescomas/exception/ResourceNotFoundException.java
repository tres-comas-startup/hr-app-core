package com.trescomas.exception;

import com.trescomas.domain.model.BaseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(Long id) {
        super(String.format("Couldn't find resource with id %d", id));
    }

    public ResourceNotFoundException(Long id, Class<BaseEntity> clazz) {
        super(String.format("Couldn't find %s with id %d", clazz.getSimpleName(), id));
    }

    public ResourceNotFoundException(Long id, String message) {
        super(message);
    }

}

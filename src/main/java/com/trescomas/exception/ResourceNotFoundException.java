package com.trescomas.exception;

import com.trescomas.domain.model.BaseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotNull;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(@NotNull String message) {
        super(message);
    }

    public ResourceNotFoundException(@NotNull Long id) {
        super(String.format("Couldn't find resource with id %d", id));
    }

    public ResourceNotFoundException(@NotNull Long id, @NotNull Class<BaseEntity> clazz) {
        super(String.format("Couldn't find %s with id %d", clazz.getSimpleName(), id));
    }

    public ResourceNotFoundException(@NotNull Long id, @NotNull String message) {
        super(message);
    }

}

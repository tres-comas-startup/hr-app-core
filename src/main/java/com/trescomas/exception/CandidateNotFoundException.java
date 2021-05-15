package com.trescomas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotNull;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CandidateNotFoundException extends ResourceNotFoundException {

    public CandidateNotFoundException(@NotNull Long id) {
        super(id, String.format("Couldn't find a candidate with id: %d", id));
    }
}

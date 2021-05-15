package com.trescomas.exception;

import javax.validation.constraints.NotNull;

public class UserNotFoundException extends ResourceNotFoundException {

    public UserNotFoundException(@NotNull Long id) {
        super(String.format("Couldn't find user with id: %d", id));
    }

    public UserNotFoundException(@NotNull String username) {
        super(String.format("Couldn't find user with username: %s", username));
    }
}

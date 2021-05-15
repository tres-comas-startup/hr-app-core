package com.trescomas.exception;

import com.trescomas.domain.enums.RoleTitle;

import javax.validation.constraints.NotNull;

public class RoleNotFoundException extends ResourceNotFoundException {

    public RoleNotFoundException(@NotNull Long id) {
        super(String.format("Couldn't find role with id: %d", id));
    }

    public RoleNotFoundException(@NotNull RoleTitle title) {
        super(String.format("Couldn't find role with title: %s", title.name()));
    }
}

package com.trescomas.domain.dto.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public record CreateUserRequest(
        @Email @NotNull String username,
        @NotNull String password,
        @NotNull String fullName) {
}

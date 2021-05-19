package com.trescomas.domain.dto.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public record RegisterRequest(
        @NotNull @Email String username,
        @NotNull String password,
        @NotNull String firstName,
        @NotNull String lastName) {
}

package com.trescomas.domain.dto.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public record LoginRequest(@NotNull @Email String username, @NotNull String password) {
}
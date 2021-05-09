package com.trescomas.domain.dto.api;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


public record AuthRequest(@NotNull @Email String username, @NotNull String password) {
}
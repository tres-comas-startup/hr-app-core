package com.trescomas.domain.dto.user;

import javax.validation.constraints.NotNull;

public record UpdateUserRequest(@NotNull String fullName) {
}

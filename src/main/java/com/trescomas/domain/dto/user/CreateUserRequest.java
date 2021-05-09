package com.trescomas.domain.dto.user;

import com.trescomas.domain.model.role.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;

public record CreateUserRequest(@Email @NotNull String username,
                                @NotNull String password,
                                @NotNull String fullName,
                                @NotNull Set<Role> authorities) {
}

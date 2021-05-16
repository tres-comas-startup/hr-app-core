package com.trescomas.domain.dto.user;

import com.trescomas.domain.model.Role;

import javax.validation.constraints.NotNull;
import java.util.Set;

public record ChangeAuthoritiesRequest(@NotNull Long id, @NotNull Set<Role> roles) {
}

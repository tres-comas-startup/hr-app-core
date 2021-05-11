package com.trescomas.domain.dto.technology;

import javax.validation.constraints.NotNull;

public record CreateTechnologyRequest(@NotNull String name) {
}

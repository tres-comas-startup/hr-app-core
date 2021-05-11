package com.trescomas.domain.dto.technology;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public record CreateTechnologyRequest(@NotNull @Max(255) String name) {
}

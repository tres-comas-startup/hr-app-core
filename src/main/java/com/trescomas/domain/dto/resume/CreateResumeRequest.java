package com.trescomas.domain.dto.resume;

import com.trescomas.domain.model.Technology;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

public record CreateResumeRequest(
        @NotNull LocalDate birthDate,
        @Min(0) @Max(99) int experienceYears,
        @NotNull Set<Technology> technologies,
        @Max(255) String note
) {
}

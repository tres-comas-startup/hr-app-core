package com.trescomas.domain.dto.candidate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCreateRequest {
    @NotNull
    private LocalDate birthDate;
    @NotNull @Min(0)
    Integer experience;
    @NotNull @Min(0) Double desiredSalary;
    @NotNull String fullName;
    @Email @NotNull String email;
    @NotNull String phone;
    String note;
    @NotNull Long userId;
}
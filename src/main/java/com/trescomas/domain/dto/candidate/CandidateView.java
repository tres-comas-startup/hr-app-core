package com.trescomas.domain.dto.candidate;

import com.trescomas.domain.dto.candidateStatus.CandidateStatusView;
import com.trescomas.domain.dto.technology.TechnologyView;

import java.time.LocalDateTime;
import java.util.Set;

public record CandidateView(
        LocalDateTime birthDate,
        Integer experience,
        CandidateStatusView candidateStatus,
        Double desiredSalary,
        String fullName,
        String email,
        String phone,
        String note,
        Long userId,
        Set<TechnologyView> technologies
) {
}

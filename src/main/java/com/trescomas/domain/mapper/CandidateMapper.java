package com.trescomas.domain.mapper;

import com.trescomas.domain.dto.candidate.CandidateCreateRequest;
import com.trescomas.domain.dto.candidate.CandidateView;
import com.trescomas.domain.model.Candidate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CandidateMapper {

    @Mapping(target = "fullName", source = "user.fullName")
    CandidateView toView(Candidate candidate);

    Candidate toCandidate(CandidateCreateRequest candidateCreateRequest);
}

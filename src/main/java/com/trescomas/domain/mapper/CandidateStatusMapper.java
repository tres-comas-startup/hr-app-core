package com.trescomas.domain.mapper;

import com.trescomas.domain.dto.candidateStatus.CandidateStatusView;
import com.trescomas.domain.model.CandidateStatus;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CandidateStatusMapper {

    CandidateStatusView toView(CandidateStatus candidateStatus);

}

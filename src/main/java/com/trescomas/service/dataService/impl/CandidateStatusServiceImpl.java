package com.trescomas.service.dataService.impl;

import com.trescomas.domain.enums.CandidateStatusTitle;
import com.trescomas.domain.model.candidate.CandidateStatus;
import com.trescomas.service.abstraction.CandidateStatusService;
import com.trescomas.service.dataService.impl.CandidateStatusDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CandidateStatusServiceImpl implements CandidateStatusService {

    private final CandidateStatusDataService candidateStatusDataService;

    public CandidateStatus getApprovedStatus() {
        return candidateStatusDataService.candidateStatusRepository
                .findByTitle(CandidateStatusTitle.APPROVED)
                .orElseThrow();
    }

    public CandidateStatus getRejectedStatus() {
        return candidateStatusDataService.candidateStatusRepository
                .findByTitle(CandidateStatusTitle.REJECTED)
                .orElseThrow();
    }

}

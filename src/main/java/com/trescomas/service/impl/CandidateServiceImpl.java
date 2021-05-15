package com.trescomas.service.impl;

import com.trescomas.domain.dto.candidate.CandidateCreateRequest;
import com.trescomas.domain.dto.candidate.CandidateUpdateRequest;
import com.trescomas.domain.dto.candidate.CandidateView;
import com.trescomas.domain.mapper.CandidateMapper;
import com.trescomas.domain.model.candidate.CandidateStatus;
import com.trescomas.service.abstraction.CandidateService;
import com.trescomas.service.dataService.impl.CandidateStatusDataService;
import com.trescomas.service.dataService.impl.CandidateDataServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateDataServiceImpl candidateDataService;
    private final CandidateStatusDataService candidateStatusDataService;
    private final CandidateMapper candidateMapper;

    @Override
    public List<CandidateView> listApproved() {
        log.debug("List approved candidates");
//        return candidateRepository.findAllByStatusTitle(CandidateStatusTitle.APPROVED);
        return null;
    }

    @Override
    public List<CandidateView> listRejected() {
        log.debug("List rejected candidates");
//        return candidateRepository.findAllByStatusTitle(CandidateStatusTitle.REJECTED);
        return null;
    }

    @Transactional
    @Override
    public CandidateView approve(Long id) {
        log.debug("Approve candidate: {}", id);
        return updateStatus(id, candidateStatusDataService.getApprovedStatus());
    }


    @Transactional
    @Override
    public CandidateView reject(Long id) {
        log.debug("Reject candidate: {}", id);
        return updateStatus(id, candidateStatusDataService.getRejectedStatus());
    }

    @Override
    public List<CandidateView> list() {
        return null;
    }

    @Override
    public CandidateView getOne(Long id) {
        final var candidate = candidateDataService.get(id);
        return candidateMapper.toView(candidate);
    }

    @Override
    public CandidateView create(CandidateCreateRequest candidateCreateRequest) {
        final var candidate = candidateMapper.toCandidate(candidateCreateRequest);
        final var savedCandidate = candidateDataService.save(candidate);
        return candidateMapper.toView(savedCandidate);
    }

    @Override
    public CandidateView update(Long id, CandidateUpdateRequest candidateUpdateRequest) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        candidateDataService.deleteById(id);
    }

    private CandidateView updateStatus(Long candidateId, CandidateStatus status) {
        final var candidate = candidateDataService.get(candidateId);
        candidate.setStatus(status);
        final var savedCandidate = candidateDataService.save(candidate);
        return candidateMapper.toView(savedCandidate);
    }

}

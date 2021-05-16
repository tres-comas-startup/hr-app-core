package com.trescomas.service.dataService.impl;

import com.trescomas.domain.enums.CandidateStatusTitle;
import com.trescomas.domain.model.CandidateStatus;
import com.trescomas.repository.CandidateStatusRepository;
import com.trescomas.service.dataService.abstraction.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CandidateStatusDataService implements DataService<CandidateStatus, Long> {

    protected final CandidateStatusRepository candidateStatusRepository;

    @Override
    public Long count() {
        return candidateStatusRepository.count();
    }

    @Override
    public List<CandidateStatus> list() {
        log.debug("List all candidateStatuses");
        return (List<CandidateStatus>) candidateStatusRepository.findAll();
    }

    @Override
    public CandidateStatus get(Long id) {
        log.debug("Get candidateStatus with id: {}", id);
        return candidateStatusRepository.get(id);
    }

    @Transactional
    @Override
    public CandidateStatus save(CandidateStatus candidateStatus) {
        log.debug("Save candidateStatus: {}", candidateStatus);
        return candidateStatusRepository.save(candidateStatus);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Delete candidateStatus: {}", id);
        candidateStatusRepository.deleteById(id);
    }

    public CandidateStatus getApprovedStatus() {
        log.debug("Fetch approvedStatus");
        return candidateStatusRepository.get(CandidateStatusTitle.APPROVED);
    }

    public CandidateStatus getRejectedStatus() {
        log.debug("Fetch approvedStatus");
        return candidateStatusRepository.get(CandidateStatusTitle.REJECTED);
    }

}

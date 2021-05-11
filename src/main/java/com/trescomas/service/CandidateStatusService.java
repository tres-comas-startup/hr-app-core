package com.trescomas.service;

import com.trescomas.domain.constants.CandidateStatusTitle;
import com.trescomas.domain.model.CandidateStatus;
import com.trescomas.repository.CandidateStatusRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CandidateStatusService implements DataService<CandidateStatus, Long> {

    private final CandidateStatusRepository candidateStatusRepository;

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
        return candidateStatusRepository.findById(id).orElseThrow();
    }

    @Transactional
    @Override
    public CandidateStatus save(CandidateStatus candidateStatus) {
        log.debug("Save candidateStatus: {}", candidateStatus);
        return candidateStatusRepository.save(candidateStatus);
    }

    @Transactional
    @Override
    public List<CandidateStatus> saveAll(List<CandidateStatus> candidateStatuses) {
        log.debug("Save candidateStatuses: {}", candidateStatuses);
        return (List<CandidateStatus>) candidateStatusRepository.saveAll(candidateStatuses);
    }

    @Transactional
    @Override
    public void delete(CandidateStatus candidateStatus) {
        log.debug("Delete candidateStatus: {}", candidateStatus);
        candidateStatusRepository.delete(candidateStatus);
    }

    public CandidateStatus getApprovedStatus() {
        return candidateStatusRepository
                .findByTitle(CandidateStatusTitle.APPROVED.value())
                .orElseThrow();
    }

    public CandidateStatus getRejectedStatus() {
        return candidateStatusRepository
                .findByTitle(CandidateStatusTitle.REJECTED.value())
                .orElseThrow();
    }

}

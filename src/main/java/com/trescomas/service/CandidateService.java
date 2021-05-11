package com.trescomas.service;

import com.trescomas.domain.constants.CandidateStatusTitle;
import com.trescomas.domain.model.Candidate;
import com.trescomas.domain.model.CandidateStatus;
import com.trescomas.repository.CandidateRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CandidateService implements DataService<Candidate, Long> {

    private final Logger log;
    private final CandidateRepository candidateRepository;
    private final CandidateStatusService candidateStatusService;

    @Override
    public Long count() {
        return candidateRepository.count();
    }

    @Override
    public List<Candidate> list() {
        log.debug("List all candidates");
        return (List<Candidate>) candidateRepository.findAll();
    }

    @Override
    public Candidate get(Long id) {
        log.debug("Get candidate with id: {}", id);
        return candidateRepository.findById(id).orElseThrow();
    }

    @Transactional
    @Override
    public Candidate save(Candidate candidate) {
        log.debug("Save candidate: {}", candidate);
        return candidateRepository.save(candidate);
    }

    @Transactional
    @Override
    public List<Candidate> saveAll(List<Candidate> candidates) {
        log.debug("Save candidates: {}", candidates);
        return (List<Candidate>) candidateRepository.saveAll(candidates);
    }

    @Transactional
    @Override
    public void delete(Candidate candidate) {
        log.debug("Delete candidate: {}", candidate);
        candidateRepository.delete(candidate);
    }

    @Transactional
    public Candidate approve(Candidate candidate) {
        log.debug("Approve candidate: {}", candidate);
        return setStatus(candidate, candidateStatusService.getApprovedStatus());
    }

    @Transactional
    public List<Candidate> approveAll(List<Candidate> candidates) {
        log.debug("Approve candidates: {}", candidates);
        return (List<Candidate>) setStatusForAll(candidates, candidateStatusService.getApprovedStatus());
    }

    @Transactional
    public Candidate reject(Candidate candidate) {
        log.debug("Reject candidate: {}", candidate);
        return setStatus(candidate, candidateStatusService.getRejectedStatus());
    }

    @Transactional
    public List<Candidate> rejectAll(List<Candidate> candidates) {
        log.debug("Reject candidates: {}", candidates);
        return (List<Candidate>) setStatusForAll(candidates, candidateStatusService.getRejectedStatus());
    }

    public List<Candidate> listApproved() {
        return listByStatusTitle(CandidateStatusTitle.APPROVED);
    }

    public List<Candidate> listNotApproved() {
        return listByStatusTitle(CandidateStatusTitle.REJECTED);
    }

    private List<Candidate> listByStatusTitle(CandidateStatusTitle candidateStatusTitle) {
        log.debug("List resumes with status: {}", candidateStatusTitle);
        return candidateRepository.findAllByStatusTitle(candidateStatusTitle.value());
    }

    private Candidate setStatus(Candidate candidate, CandidateStatus candidateStatus) {
        log.debug("Set status {} to candidate {}", candidate, candidateStatus.getTitle());

        if (!candidate.getStatus().equals(candidateStatus)) {
            candidate.setStatus(candidateStatus);
            return save(candidate);
        }

        // Current status is already approved
        log.warn("Candidate has already got this status. Ignore candidate");
        return candidate;
    }

    private Iterable<Candidate> setStatusForAll(List<Candidate> candidates, CandidateStatus candidateStatus) {
        return saveAll(candidates.stream()
                .filter(candidate -> !candidate
                        .getStatus()
                        .equals(candidateStatus))
                .peek(candidate -> candidate.setStatus(candidateStatus))
                .toList());
    }

}

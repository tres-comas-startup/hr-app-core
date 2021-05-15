package com.trescomas.service.dataService.impl;

import com.trescomas.domain.enums.CandidateStatusTitle;
import com.trescomas.domain.model.candidate.Candidate;
import com.trescomas.domain.model.candidate.CandidateStatus;
import com.trescomas.repository.CandidateRepository;
import com.trescomas.service.dataService.abstraction.CandidateDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class CandidateDataServiceImpl implements CandidateDataService {

    private final CandidateRepository candidateRepository;

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
        return candidateRepository.get(id);
    }

    @Transactional
    @Override
    public Candidate save(Candidate candidate) {
        Objects.requireNonNull(candidate);
        log.debug("Save candidate: {}", candidate);
        return candidateRepository.save(candidate);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Delete candidate: {}", id);
        candidateRepository.deleteById(id);
    }

    public List<Candidate> findAllByStatus(CandidateStatus status) {
        log.debug("Find all candidates with status {}", status);
        return candidateRepository.findAllByStatus(status);
    }

    public List<Candidate> findAllByStatusTitle(CandidateStatusTitle statusTitle) {
        log.debug("Find all candidates with status title {}", statusTitle);
        return candidateRepository.findAllByStatusTitle(statusTitle);
    }
}

package com.trescomas.repository;

import com.trescomas.domain.enums.CandidateStatusTitle;
import com.trescomas.domain.model.candidate.Candidate;
import com.trescomas.domain.model.candidate.CandidateStatus;
import com.trescomas.exception.CandidateNotFoundException;
import com.trescomas.repository.BaseRepository;

import java.util.List;

public interface CandidateRepository extends BaseRepository<Candidate, Long> {

    default Candidate get(Long id) {
        return findById(id).orElseThrow(() -> new CandidateNotFoundException(id));
    }

    List<Candidate> findAllByStatus(CandidateStatus status);

    List<Candidate> findAllByStatusTitle(CandidateStatusTitle candidateStatusTitle);

}

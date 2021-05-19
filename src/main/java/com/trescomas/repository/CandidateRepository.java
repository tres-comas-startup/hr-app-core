package com.trescomas.repository;

import com.trescomas.domain.model.Candidate;
import com.trescomas.exception.CandidateNotFoundException;

public interface CandidateRepository extends BaseRepository<Candidate, Long> {

    default Candidate get(Long id) {
        return findById(id).orElseThrow(() -> new CandidateNotFoundException(id));
    }

}

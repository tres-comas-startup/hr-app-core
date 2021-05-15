package com.trescomas.repository;

import com.trescomas.domain.enums.CandidateStatusTitle;
import com.trescomas.domain.model.candidate.CandidateStatus;
import com.trescomas.exception.CandidateStatusNotFoundException;
import com.trescomas.repository.BaseRepository;

import java.util.Optional;

public interface CandidateStatusRepository extends BaseRepository<CandidateStatus, Long> {

    Optional<CandidateStatus> findByTitle(CandidateStatusTitle title);

    default CandidateStatus get(CandidateStatusTitle title) {
        return findByTitle(title)
                .orElseThrow(() -> new CandidateStatusNotFoundException(title));
    }
}

package com.trescomas.repository;

import com.trescomas.domain.constants.CandidateStatusTitle;
import com.trescomas.domain.model.CandidateStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CandidateStatusRepository extends CrudRepository<CandidateStatus, Long> {

    Optional<CandidateStatus> findByTitle(String title);

}

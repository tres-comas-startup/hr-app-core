package com.trescomas.repository;

import com.trescomas.domain.model.Candidate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CandidateRepository extends CrudRepository<Candidate, Long> {

    List<Candidate> findAllByStatusTitle(String statusTitle);

}

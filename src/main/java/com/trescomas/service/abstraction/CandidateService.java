package com.trescomas.service.abstraction;

import com.trescomas.domain.dto.candidate.CandidateCreateRequest;
import com.trescomas.domain.dto.candidate.CandidateUpdateRequest;
import com.trescomas.domain.dto.candidate.CandidateView;

import java.util.List;

public interface CandidateService {

    List<CandidateView> list();

    CandidateView getOne(Long id);

    CandidateView create(CandidateCreateRequest candidateCreateRequest);

    CandidateView update(Long id, CandidateUpdateRequest candidateUpdateRequest);

    void deleteById(Long id);

    List<CandidateView> listApproved();

    List<CandidateView> listRejected();

    CandidateView approve(Long id);

    CandidateView reject(Long id);

}

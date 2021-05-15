package com.trescomas.exception;

import com.trescomas.domain.enums.CandidateStatusTitle;

public class CandidateStatusNotFoundException extends ResourceNotFoundException {

    public CandidateStatusNotFoundException(Long id) {
        super(id);
    }

    public CandidateStatusNotFoundException(CandidateStatusTitle title) {
        super(String.format("Couldn't find CandidateStatus with title: %s", title.name()));
    }

}

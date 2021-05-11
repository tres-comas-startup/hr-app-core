package com.trescomas.domain.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CandidateStatusTitle {

    APPROVED("APPROVED"),
    REJECTED("REJECTED");

    private final String value;

    public String value() {
        return this.value;
    }

}

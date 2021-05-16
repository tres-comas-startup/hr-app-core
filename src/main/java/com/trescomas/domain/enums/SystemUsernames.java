package com.trescomas.domain.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SystemUsernames {

    ADMIN("admin@hrapp.trescommas.com"),
    HR_MANAGER("hr@hrapp.trescommas.com");

    private final String value;

}

package com.trescomas.domain.model;

import com.trescomas.domain.enums.EducationType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass
public class EducationInfo extends BaseEntity<Long> {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EducationType type;

    @Column(nullable = false)
    private LocalDate admissionDate;

    @Column(nullable = false)
    private LocalDate graduationDate;

    @Column(nullable = false)
    private String nameOfInstitution;

}

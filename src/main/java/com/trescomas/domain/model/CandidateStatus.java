package com.trescomas.domain.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Data
@Table(name = "candidate_statuses")
@Entity
public class CandidateStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false, unique = true)
    private String title;

    private String note;

}

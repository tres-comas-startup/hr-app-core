package com.trescomas.domain.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Set;

@Data
@Table(name = "candidate_statuses")
@Entity
public class CandidateStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false, unique = true, length = 50)
    private String title;

    private String note;

    @OneToMany
    @JoinColumn(name = "candidate_id")
    private Set<Candidate> candidates;

}

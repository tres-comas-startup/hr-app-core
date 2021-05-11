package com.trescomas.domain.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private LocalDate birthDate;

    @Min(0)
    @Max(99)
    @NonNull
    @Column(nullable = false)
    private Integer experienceYears;

    private String note;

    @NonNull
    @ManyToMany
    @JoinTable(
            name = "candidates_technologies",
            joinColumns = @JoinColumn(name = "candidate_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id", referencedColumnName = "id")
    )
    private Set<Technology> technologies;

    @OneToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private CandidateStatus status;

}

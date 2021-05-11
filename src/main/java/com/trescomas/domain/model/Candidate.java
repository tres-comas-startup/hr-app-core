package com.trescomas.domain.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.HashSet;
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
    private Set<Technology> technologies = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private CandidateStatus status;

    public Candidate addTechnology(Technology technology) {
        this.technologies.add(technology);
        return this;
    }

    public Candidate addTechnologies(Set<Technology> technologies) {
        this.technologies.addAll(technologies);
        return this;
    }

}

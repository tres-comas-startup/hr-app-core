package com.trescomas.domain.model.candidate;

import com.trescomas.domain.model.BaseEntity;
import com.trescomas.domain.model.technology.Technology;
import com.trescomas.domain.model.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "candidates")
public class Candidate extends BaseEntity {

    @Column(nullable = false)
    private LocalDate birthDate;

    @Min(0)
    @Max(99)
    @Column(nullable = false)
    private Integer experienceYears;

    @Min(0)
    @Column(nullable = false)
    private BigDecimal desiredSalary;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;

    private String note;

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

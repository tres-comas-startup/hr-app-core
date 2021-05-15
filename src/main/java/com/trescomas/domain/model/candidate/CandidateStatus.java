package com.trescomas.domain.model.candidate;

import com.trescomas.domain.enums.CandidateStatusTitle;
import com.trescomas.domain.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "candidate_statuses")
@Entity
public class CandidateStatus extends BaseEntity {

    @NonNull
    @Column(nullable = false, unique = true, length = 50)
    @Enumerated(EnumType.STRING)
    private CandidateStatusTitle title;

    private String note;

    @OneToMany
    @JoinColumn(name = "candidate_id")
    private Set<Candidate> candidates;

}

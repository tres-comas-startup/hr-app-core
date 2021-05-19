package com.trescomas.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "candidates_reviews")
public class CandidateReview extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "review_statement_id", nullable = false)
    private ReviewStatement statement;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

}

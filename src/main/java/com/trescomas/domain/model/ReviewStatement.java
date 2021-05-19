package com.trescomas.domain.model;

import com.trescomas.domain.enums.ReviewStatementTitle;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "review_statements")
public class ReviewStatement extends BaseEntity<Long> {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private ReviewStatementTitle title;

    @OneToMany(mappedBy = "statement")
    List<CandidateReview> reviews;

}

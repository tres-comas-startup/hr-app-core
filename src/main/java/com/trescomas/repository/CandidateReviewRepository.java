package com.trescomas.repository;

import com.trescomas.domain.enums.ReviewStatementTitle;
import com.trescomas.domain.model.CandidateReview;

import java.util.List;

public interface CandidateReviewRepository extends BaseRepository<CandidateReview, Long> {

    List<CandidateReview> findAllByStatementTitle(ReviewStatementTitle title);

}

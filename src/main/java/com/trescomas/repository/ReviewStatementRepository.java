package com.trescomas.repository;

import com.trescomas.domain.enums.ReviewStatementTitle;
import com.trescomas.domain.model.ReviewStatement;

import java.util.Optional;

public interface ReviewStatementRepository extends BaseRepository<ReviewStatement, Long> {

    boolean existsByTitle(ReviewStatementTitle title);

    Optional<ReviewStatement> findByTitle(ReviewStatementTitle title);

}

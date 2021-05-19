package com.trescomas.service.dataService.abstraction;

import com.trescomas.domain.enums.ReviewStatementTitle;
import com.trescomas.domain.model.ReviewStatement;

import java.util.Optional;

public interface ReviewStatementDataService extends DataService<ReviewStatement, Long> {

    ReviewStatement create(ReviewStatementTitle title);

    boolean existsByTitle(ReviewStatementTitle title);

    Optional<ReviewStatement> findByTitle(ReviewStatementTitle title);

}

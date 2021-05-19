package com.trescomas.service.dataService.impl;

import com.trescomas.domain.enums.ReviewStatementTitle;
import com.trescomas.domain.model.ReviewStatement;
import com.trescomas.repository.ReviewStatementRepository;
import com.trescomas.service.dataService.abstraction.ReviewStatementDataService;
import com.trescomas.service.impl.BaseDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ReviewStatementDataServiceImpl
        extends BaseDataService<ReviewStatement, Long>
        implements ReviewStatementDataService {

    public ReviewStatementDataServiceImpl(ReviewStatementRepository repository) {
        super(repository);
    }

    @Override
    public ReviewStatement create(ReviewStatementTitle title) {
        log.debug("Create a new ReviewStatement");
        final var reviewStatement = new ReviewStatement();
        reviewStatement.setTitle(title);

        return save(reviewStatement);
    }

    @Override
    public boolean existsByTitle(ReviewStatementTitle title) {
        return false;
    }

    @Override
    public Optional<ReviewStatement> findByTitle(ReviewStatementTitle title) {
        return Optional.empty();
    }
}

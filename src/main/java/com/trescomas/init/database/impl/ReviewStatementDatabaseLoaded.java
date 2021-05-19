package com.trescomas.init.database.impl;

import com.trescomas.domain.enums.ReviewStatementTitle;
import com.trescomas.domain.model.ReviewStatement;
import com.trescomas.init.database.abstraction.AbstractDatabaseLoader;
import com.trescomas.service.dataService.abstraction.ReviewStatementDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.function.Predicate;

@Slf4j
@Component
public class ReviewStatementDatabaseLoaded extends AbstractDatabaseLoader<ReviewStatement, Long> {

    public ReviewStatementDatabaseLoaded(ReviewStatementDataService dataService) {
        super(dataService);
    }

    @Override
    public void load() {
        log.debug(super.getInitialMessage());

        final var dataService = (ReviewStatementDataService) super.dataService;
        Arrays.stream(ReviewStatementTitle.values())
                .filter(Predicate.not(dataService::existsByTitle))
                .forEach(dataService::create);

        log.debug(super.getCompletedMessage());
    }

}

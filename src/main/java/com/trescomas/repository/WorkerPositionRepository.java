package com.trescomas.repository;

import com.trescomas.domain.enums.WorkerPositionTitle;
import com.trescomas.domain.model.WorkerPosition;

import java.util.Optional;

public interface WorkerPositionRepository extends BaseRepository<WorkerPosition, Long> {

    Optional<WorkerPosition> findByTitle(WorkerPositionTitle title);

}

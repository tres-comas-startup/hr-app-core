package com.trescomas.repository;

import com.trescomas.domain.enums.WorkerPositionTitle;
import com.trescomas.domain.model.worker.WorkerPosition;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WorkerPositionRepository extends CrudRepository<WorkerPosition, Long> {

    Optional<WorkerPosition> findByTitle(WorkerPositionTitle title);

}

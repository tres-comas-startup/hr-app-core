package com.trescomas.repository;

import com.trescomas.domain.enums.WorkerPositionTitle;
import com.trescomas.domain.model.Worker;
import com.trescomas.domain.model.WorkerPosition;

import java.util.List;

public interface WorkerRepository extends BaseRepository<Worker, Long> {

    List<Worker> findAllByPosition(WorkerPosition position);

    List<Worker> findAllByPositionTitle(WorkerPositionTitle title);

}

package com.trescomas.repository;

import com.trescomas.domain.model.Worker;
import org.springframework.data.repository.CrudRepository;

public interface WorkerRepository extends CrudRepository<Worker, Long> {
}

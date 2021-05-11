package com.trescomas.service;

import com.trescomas.domain.model.Worker;
import com.trescomas.repository.WorkerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class WorkerService implements DataService<Worker, Long> {

    private final WorkerRepository workerRepository;

    @Override
    public Long count() {
        return workerRepository.count();
    }

    @Override
    public List<Worker> list() {
        return (List<Worker>) workerRepository.findAll();
    }

    @Override
    public Worker get(Long id) {
        return workerRepository.findById(id).orElseThrow();
    }

    @Transactional
    @Override
    public Worker save(Worker instance) {
        return workerRepository.save(instance);
    }

    @Transactional
    @Override
    public List<Worker> saveAll(List<Worker> instances) {
        return (List<Worker>) workerRepository.saveAll(instances);
    }

    @Transactional
    @Override
    public void delete(Worker instance) {
        workerRepository.delete(instance);
    }
}

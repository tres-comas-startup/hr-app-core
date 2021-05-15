package com.trescomas.service.dataService.impl;

import com.trescomas.domain.model.worker.Worker;
import com.trescomas.repository.WorkerRepository;
import com.trescomas.service.dataService.abstraction.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkerDataService implements DataService<Worker, Long> {

    protected final WorkerRepository workerRepository;

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
        return workerRepository.get(id);
    }

    @Transactional
    @Override
    public Worker save(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public void deleteById(Long id) {
        workerRepository.deleteById(id);
    }

}

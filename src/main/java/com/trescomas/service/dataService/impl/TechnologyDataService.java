package com.trescomas.service.dataService.impl;

import com.trescomas.domain.model.technology.Technology;
import com.trescomas.repository.TechnologyRepository;
import com.trescomas.service.dataService.abstraction.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TechnologyDataService implements DataService<Technology, Long> {

    private final TechnologyRepository technologyRepository;

    @Override
    public Long count() {
        return technologyRepository.count();
    }

    @Override
    public List<Technology> list() {
        return (List<Technology>) technologyRepository.findAll();
    }

    @Override
    public Technology get(Long id) {
        return technologyRepository.get(id);
    }

    @Transactional
    @Override
    public Technology save(Technology technology) {
        return technologyRepository.save(technology);
    }

    @Override
    public void deleteById(Long id) {
        technologyRepository.deleteById(id);
    }
}

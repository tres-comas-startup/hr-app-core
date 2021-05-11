package com.trescomas.service;

import com.trescomas.domain.model.Technology;
import com.trescomas.repository.TechnologyRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TechnologyService implements DataService<Technology, Long> {

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
        return technologyRepository.findById(id).orElseThrow();
    }

    @Transactional
    @Override
    public Technology save(Technology instance) {
        return technologyRepository.save(instance);
    }

    @Transactional
    @Override
    public List<Technology> saveAll(List<Technology> instances) {
        return (List<Technology>) technologyRepository.saveAll(instances);
    }

    @Transactional
    @Override
    public void delete(Technology instance) {
        technologyRepository.delete(instance);
    }
}

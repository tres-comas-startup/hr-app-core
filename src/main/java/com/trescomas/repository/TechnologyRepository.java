package com.trescomas.repository;

import com.trescomas.domain.model.technology.Technology;
import com.trescomas.repository.BaseRepository;

import java.util.Optional;

public interface TechnologyRepository extends BaseRepository<Technology> {

    Optional<Technology> findByName(String name);

}

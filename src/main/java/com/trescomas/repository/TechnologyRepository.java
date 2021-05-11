package com.trescomas.repository;

import com.trescomas.domain.model.Technology;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TechnologyRepository extends CrudRepository<Technology, Long> {

    Optional<Technology> findByName(String name);

}

package com.trescomas.repository;

import com.trescomas.domain.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test, Long> {
}

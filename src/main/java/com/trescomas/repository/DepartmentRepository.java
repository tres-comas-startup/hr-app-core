package com.trescomas.repository;

import com.trescomas.domain.model.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

    Optional<Department> findByName(String name);

}

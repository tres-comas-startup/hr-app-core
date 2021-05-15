package com.trescomas.repository;

import com.trescomas.domain.enums.DepartmentTypeTitle;
import com.trescomas.domain.model.department.DepartmentType;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DepartmentTypeRepository extends CrudRepository<DepartmentType, Long> {

    Optional<DepartmentType> findByTitle(DepartmentTypeTitle title);

}

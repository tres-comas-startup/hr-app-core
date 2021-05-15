package com.trescomas.repository;

import com.trescomas.domain.enums.DepartmentTypeTitle;
import com.trescomas.domain.model.department.DepartmentType;

import java.util.Optional;

public interface DepartmentTypeRepository extends BaseRepository<DepartmentType, Long> {

    Optional<DepartmentType> findByTitle(DepartmentTypeTitle title);

}

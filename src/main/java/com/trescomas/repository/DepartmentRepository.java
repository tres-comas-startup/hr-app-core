package com.trescomas.repository;

import com.trescomas.domain.enums.DepartmentTypeTitle;
import com.trescomas.domain.model.Department;
import com.trescomas.domain.model.DepartmentType;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends BaseRepository<Department, Long> {

    Optional<Department> findByName(String name);

    List<Department> findAllByDepartmentType(DepartmentType departmentType);

    List<Department> findAllByDepartmentTypeTitle(DepartmentTypeTitle departmentTypeTitle);

}

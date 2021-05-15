package com.trescomas.repository;

import com.trescomas.domain.enums.DepartmentTypeTitle;
import com.trescomas.domain.model.department.Department;
import com.trescomas.domain.model.department.DepartmentType;
import com.trescomas.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends BaseRepository<Department, Long> {

    Optional<Department> findByName(String name);

    List<Department> findAllByDepartmentType(DepartmentType departmentType);

    List<Department> findAllByDepartmentTypeTitle(DepartmentTypeTitle departmentTypeTitle);

}

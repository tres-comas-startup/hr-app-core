package com.trescomas.service.dataService.impl;

import com.trescomas.domain.model.department.Department;
import com.trescomas.repository.DepartmentRepository;
import com.trescomas.service.dataService.abstraction.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentDataService implements DataService<Department, Long> {

    private final DepartmentRepository departmentRepository;

    @Override
    public Long count() {
        return departmentRepository.count();
    }

    @Override
    public List<Department> list() {
        return (List<Department>) departmentRepository.findAll();
    }

    @Override
    public Department get(Long id) {
        return departmentRepository.get(id);
    }

    @Transactional
    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }

}

package com.trescomas.service;

import com.trescomas.domain.model.Department;
import com.trescomas.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class DepartmentService implements DataService<Department, Long> {

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
        return departmentRepository.findById(id).orElseThrow();
    }

    @Transactional
    @Override
    public Department save(Department instance) {
        return departmentRepository.save(instance);
    }

    @Transactional
    @Override
    public List<Department> saveAll(List<Department> instances) {
        return (List<Department>) departmentRepository.saveAll(instances);
    }

    @Transactional
    @Override
    public void delete(Department instance) {
        departmentRepository.delete(instance);
    }
}

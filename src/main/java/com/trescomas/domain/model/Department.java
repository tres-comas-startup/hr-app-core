package com.trescomas.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "departments")
@Entity
public class Department extends BaseEntity<Long> {

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_type_id")
    private DepartmentType departmentType;

    @ManyToMany
    @JoinTable(
            name = "departments_technologies",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id"))
    Set<Technology> technologies = new HashSet<>();

    @OneToMany(mappedBy = "department")
    private Set<Worker> workers = new HashSet<>();
    
}

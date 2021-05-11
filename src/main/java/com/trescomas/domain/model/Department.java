package com.trescomas.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Table(name = "departments")
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "department")
    private Set<Worker> workers;

    @ManyToMany
    @JoinTable(
            name = "departments_technologies",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id"))
    Set<Technology> technologies;
}

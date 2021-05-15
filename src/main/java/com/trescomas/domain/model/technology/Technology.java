package com.trescomas.domain.model.technology;

import com.trescomas.domain.model.BaseEntity;
import com.trescomas.domain.model.candidate.Candidate;
import com.trescomas.domain.model.department.Department;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "technologies")
@Entity
public class Technology extends BaseEntity {

    @NonNull
    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @ManyToMany(mappedBy = "technologies")
    Set<Candidate> candidates = new HashSet<>();

    @ManyToMany(mappedBy = "technologies")
    Set<Department> departments = new HashSet<>();

}

package com.trescomas.domain.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "technologies")
@Entity
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "technologies")
    Set<Candidate> candidates = new HashSet<>();

    @ManyToMany(mappedBy = "technologies")
    Set<Department> departments = new HashSet<>();

    @NonNull
    @Column(nullable = false, unique = true, length = 50)
    private String name;

}

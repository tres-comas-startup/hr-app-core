package com.trescomas.domain.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Set;

@Data
@Table(name = "technologies")
@Entity
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "technologies")
    Set<Candidate> candidates;

    @ManyToMany(mappedBy = "technologies")
    Set<Department> departments;

}

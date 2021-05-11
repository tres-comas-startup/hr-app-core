package com.trescomas.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "workers")
@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String note;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}

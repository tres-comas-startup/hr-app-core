package com.trescomas.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Email;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "workers")
@Entity
public class Worker extends BaseEntity<Long> {

    private String note;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "worker_position_id", nullable = false)
    private WorkerPosition position;

}

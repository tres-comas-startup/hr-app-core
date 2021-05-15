package com.trescomas.domain.model.worker;

import com.trescomas.domain.model.BaseEntity;
import com.trescomas.domain.model.department.Department;
import com.trescomas.domain.model.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "workers")
@Entity
public class Worker extends BaseEntity {

    private String note;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "worker_position_id")
    private WorkerPosition position;

}

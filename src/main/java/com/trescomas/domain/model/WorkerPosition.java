package com.trescomas.domain.model;

import com.trescomas.domain.enums.WorkerPositionTitle;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "worker_positions")
@Entity
public class WorkerPosition extends BaseEntity<Long> {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private WorkerPositionTitle title;

    @OneToMany(mappedBy = "position")
    private Set<Worker> workers;

}

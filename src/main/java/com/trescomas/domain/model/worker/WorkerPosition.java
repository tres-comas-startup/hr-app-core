package com.trescomas.domain.model.worker;

import com.trescomas.domain.enums.WorkerPositionTitle;
import com.trescomas.domain.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "worker_positions")
@Entity
public class WorkerPosition extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private WorkerPositionTitle title;

    @OneToMany(mappedBy = "position")
    private Set<Worker> workers;

}

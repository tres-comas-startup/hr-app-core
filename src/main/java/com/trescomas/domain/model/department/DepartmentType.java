package com.trescomas.domain.model.department;

import com.trescomas.domain.enums.DepartmentTypeTitle;
import com.trescomas.domain.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "department_types")
@Entity
public class DepartmentType extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private DepartmentTypeTitle title;

    @OneToMany(mappedBy = "departmentType")
    Set<Department> departments;

}

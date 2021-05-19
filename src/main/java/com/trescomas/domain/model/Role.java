package com.trescomas.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trescomas.domain.enums.RoleTitle;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties(value = {"authority"})
@EqualsAndHashCode(callSuper = true, exclude = {"users"})
@ToString(exclude = {"users"})
@Data
@Table(name = "roles")
@Entity
public class Role extends BaseEntity<Long> implements GrantedAuthority {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true, length = 50)
    private RoleTitle title;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @Override
    public String getAuthority() {
        return title.name();
    }
}

package com.trescomas.repository;

import com.trescomas.domain.enums.RoleTitle;
import com.trescomas.domain.model.Role;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface RoleRepository extends BaseRepository<Role, Long> {

    Optional<Role> findByTitle(@NotNull RoleTitle title);

    boolean existsByTitle(@NotNull RoleTitle title);

}

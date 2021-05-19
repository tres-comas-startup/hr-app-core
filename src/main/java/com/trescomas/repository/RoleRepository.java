package com.trescomas.repository;

import com.trescomas.domain.enums.RoleTitle;
import com.trescomas.domain.model.Role;
import com.trescomas.domain.projection.role.RoleExcerptProjection;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RepositoryRestResource(excerptProjection = RoleExcerptProjection.class)
public interface RoleRepository extends BaseRepository<Role, Long> {

    Optional<Role> findByTitle(@NotNull RoleTitle title);

    boolean existsByTitle(@NotNull RoleTitle title);

}

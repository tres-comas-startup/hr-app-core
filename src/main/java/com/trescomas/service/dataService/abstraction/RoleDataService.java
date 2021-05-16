package com.trescomas.service.dataService.abstraction;

import com.trescomas.domain.enums.RoleTitle;
import com.trescomas.domain.model.Role;

import javax.validation.constraints.NotNull;

public interface RoleDataService extends DataService<Role, Long> {

    Role findByTitle(@NotNull RoleTitle title);

    Role findByTitle(@NotNull String title);

    boolean existsByTitle(@NotNull RoleTitle title);

    Role create(@NotNull RoleTitle title);

}

package com.trescomas.service.dataService.abstraction;

import com.trescomas.domain.model.Role;
import com.trescomas.domain.model.User;

import javax.validation.constraints.NotNull;
import java.util.Set;

public interface UserDataService extends DataService<User, Long> {

    User create(String fullName, String username, String password, Set<Role> roles);

    User findByUsername(@NotNull String username);

    boolean existsByUsername(@NotNull String username);
    
}

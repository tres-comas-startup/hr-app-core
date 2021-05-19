package com.trescomas.config.rest;

import com.trescomas.domain.model.Role;
import com.trescomas.domain.model.User;
import com.trescomas.domain.projection.role.RoleExcerptProjection;
import com.trescomas.domain.projection.role.TitleWithUsersProjection;
import com.trescomas.domain.projection.user.UserExcerptProjection;
import com.trescomas.domain.projection.user.UsernameWithPasswordProjection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class RepositoryConfig {

    private final RepositoryRestConfiguration repositoryRestConfiguration;

    public void initProjections() {
        log.debug("Init projections...");

        repositoryRestConfiguration
                .getProjectionConfiguration()
                .addProjection(UserExcerptProjection.class, "UserExcerpt", User.class)
                .addProjection(UsernameWithPasswordProjection.class, "UsernameWithPassword", User.class)
                .addProjection(RoleExcerptProjection.class, "RoleExcerpt", Role.class)
                .addProjection(TitleWithUsersProjection.class, "TitleWithUsers", Role.class);
    }

}

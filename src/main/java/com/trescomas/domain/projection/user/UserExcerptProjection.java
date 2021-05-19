package com.trescomas.domain.projection.user;

import com.trescomas.domain.model.Role;
import com.trescomas.domain.projection.BaseProjection;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface UserExcerptProjection extends BaseProjection {

    @Value("#{target.lastName} #{target.firstName}")
    String getFullName();

    String getUsername();

    List<Role> getRoles();

}

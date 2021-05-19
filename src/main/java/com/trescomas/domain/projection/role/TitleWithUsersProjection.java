package com.trescomas.domain.projection.role;

import com.trescomas.domain.model.User;
import com.trescomas.domain.projection.BaseProjection;

import java.util.List;

public interface TitleWithUsersProjection extends BaseProjection {

    String getTitle();

    List<User> getUsers();

}

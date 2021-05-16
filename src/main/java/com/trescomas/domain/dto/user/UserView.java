package com.trescomas.domain.dto.user;

import com.trescomas.domain.dto.role.RoleView;

import java.util.Set;

public record UserView(String username, String fullName, Set<RoleView> roles) {
}


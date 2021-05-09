package com.trescomas.config.security;

import java.util.List;

public interface Constants {

    List<String> ALLOWED_ORIGINS = List.of("http://localhost:3000");

    String ROLE_ADMIN = "ROLE_ADMIN";
    String ROLE_MANAGER = "ROLE_MANAGER";
    String ROLE_WORKER = "ROLE_WORKER";

}

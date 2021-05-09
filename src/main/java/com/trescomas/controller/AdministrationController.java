package com.trescomas.controller;

import com.trescomas.config.security.Constants;
import com.trescomas.service.administration.AdministrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.Map;
import java.util.UUID;

@RolesAllowed(Constants.ROLE_ADMIN)
@RestController
@RequestMapping(value = "administration")
@AllArgsConstructor
public class AdministrationController {

    private final AdministrationService administrationService;

    @RequestMapping("resource")
    public Map<String, Object> home() {
        return Map.of("id", UUID.randomUUID().toString(), "content", "Hello World");
    }

    @GetMapping("user")
    public String helloUser() {
        return "Hello User";
    }

    @GetMapping("admin")
    public String helloAdmin() {
        return "Hello Admin";
    }

}

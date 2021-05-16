package com.trescomas.service.dataService.impl;

import com.trescomas.domain.enums.RoleTitle;
import com.trescomas.domain.model.Role;
import com.trescomas.exception.RoleNotFoundException;
import com.trescomas.repository.RoleRepository;
import com.trescomas.service.dataService.abstraction.RoleDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleDataServiceImpl implements RoleDataService {

    private final RoleRepository roleRepository;

    @Override
    public Long count() {
        return roleRepository.count();
    }

    @Override
    public List<Role> list() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public Role get(@NotNull Long id) {
        log.debug("Get role with id: {}", id);
        return roleRepository.get(id);
    }

    @Override
    public Role save(@NotNull Role role) {
        log.debug("Save role: {}", role);
        return roleRepository.save(role);
    }

    @Override
    public void deleteById(@NotNull Long id) {
        log.debug("Delete role by with: {}", id);
        roleRepository.deleteById(id);
    }

    @Override
    public Role findByTitle(@NotNull RoleTitle title) {
        log.debug("Get role with title: {}", title);
        return roleRepository
                .findByTitle(title)
                .orElseThrow(() -> new RoleNotFoundException(title));
    }

    @Override
    public Role findByTitle(@NotNull String title) {
        final var roleTitle = Optional.of(RoleTitle.valueOf(title))
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unknown role title: %s", title)));
        return findByTitle(roleTitle);
    }

    @Override
    public boolean existsByTitle(@NotNull RoleTitle title) {
        log.debug("Check whether a role with title: {} exists", title);
        return roleRepository.existsByTitle(title);
    }

    @Transactional
    @Override
    public Role create(RoleTitle title) {
        log.debug("Create a new role with title: {}", title);
        final var role = new Role();
        role.setTitle(title);
        return save(role);
    }
}

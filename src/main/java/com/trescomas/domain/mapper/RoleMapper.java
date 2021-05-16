package com.trescomas.domain.mapper;

import com.trescomas.domain.dto.role.RoleView;
import com.trescomas.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {

    @Mapping(target = "title", source = "authority")
    RoleView toView(Role role);

}

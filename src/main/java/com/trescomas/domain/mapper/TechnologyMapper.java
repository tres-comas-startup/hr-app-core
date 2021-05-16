package com.trescomas.domain.mapper;

import com.trescomas.domain.dto.technology.TechnologyView;
import com.trescomas.domain.model.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TechnologyMapper {

    TechnologyView toView(Technology technology);

}

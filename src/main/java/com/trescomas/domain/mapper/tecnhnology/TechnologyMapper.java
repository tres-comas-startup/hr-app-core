package com.trescomas.domain.mapper.tecnhnology;

import com.trescomas.domain.dto.technology.CreateTechnologyRequest;
import com.trescomas.domain.model.Technology;
import org.springframework.stereotype.Component;

@Component
public class TechnologyMapper {

    public Technology create(CreateTechnologyRequest request) {
        return new Technology(request.name());
    }

}

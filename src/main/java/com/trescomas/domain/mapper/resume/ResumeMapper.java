package com.trescomas.domain.mapper.resume;

import com.trescomas.domain.dto.resume.CreateResumeRequest;
import com.trescomas.domain.model.Candidate;
import org.springframework.stereotype.Component;

@Component
public class ResumeMapper {

    public Candidate create(CreateResumeRequest request) {
        var candidate = new Candidate(
                request.birthDate(),
                request.experienceYears()
        );
        
        return candidate.addTechnologies(request.technologies());
    }

}

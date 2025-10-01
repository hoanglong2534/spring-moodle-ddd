package com.onschool.demo.infrastructure.persistance.mapper;

import com.onschool.demo.application.dto.response.AssignResponseDTO;
import com.onschool.demo.domain.model.AssignDomain;
import com.onschool.demo.infrastructure.persistance.entity.Assign;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AssignSubmissionMapper.class})
public interface AssignDomainMapper {

    @Mapping(source = "assignmentSubmissionsList", target = "assignSubmission")
    AssignDomain toDomain(Assign assign);

    @Mapping(source = "assignSubmission", target = "assignSubmission")
    AssignResponseDTO toDTO(AssignDomain assignDomain);
}

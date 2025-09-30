package com.onschool.demo.infrastructure.persistance.mapper;

import com.onschool.demo.application.dto.response.AssignResponseDTO;
import com.onschool.demo.domain.model.AssignDomain;
import com.onschool.demo.infrastructure.persistance.entity.Assign;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AssignSubmissionMapper.class})
public interface AssignDomainMapper {

    AssignDomain toDomain(Assign assign);

    AssignResponseDTO toDTO(AssignDomain assignDomain);
}

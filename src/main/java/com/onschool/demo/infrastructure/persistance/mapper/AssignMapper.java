package com.onschool.demo.infrastructure.persistance.mapper;

import com.onschool.demo.application.dto.response.AssignResponseDTO;
import com.onschool.demo.infrastructure.persistance.entity.Assign;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AssignSubmissionMapper.class})
public interface AssignMapper {

    @Mapping(source = "assignmentSubmissionsList", target = "assignSubmission")
    AssignResponseDTO toDTO(Assign assign);

    Assign toEntity(AssignResponseDTO assignResponseDTO);
}

package com.onschool.demo.infrastructure.persistance.mapper;

import com.onschool.demo.application.dto.response.AssignSubmissionsResponseDTO;
import com.onschool.demo.infrastructure.persistance.entity.AssignmentSubmissions;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AssignSubmissionFileMapper.class})
public interface AssignSubmissionMapper {
    @Mapping(source = "assignSubmissionFileList", target = "files")
    AssignSubmissionsResponseDTO toDTO(AssignmentSubmissions assignmentSubmissions);
}

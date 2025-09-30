package com.onschool.demo.infrastructure.persistance.mapper;

import com.onschool.demo.application.dto.request.CourseModulesCompletionRequestDTO;
import com.onschool.demo.application.dto.response.CourseModulesCompletionResponseDTO;
import com.onschool.demo.infrastructure.persistance.entity.CourseModulesCompletion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseModulesCompletionMapper {

    CourseModulesCompletionResponseDTO toDTO(CourseModulesCompletion courseModulesCompletion);

    CourseModulesCompletionRequestDTO toRequestDTO(CourseModulesCompletion courseModulesCompletion);

    CourseModulesCompletion toEntity(CourseModulesCompletionRequestDTO courseModulesCompletionRequestDTO);
}

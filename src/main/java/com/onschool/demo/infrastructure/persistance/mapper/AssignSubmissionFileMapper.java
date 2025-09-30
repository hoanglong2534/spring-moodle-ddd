package com.onschool.demo.infrastructure.persistance.mapper;

import com.onschool.demo.application.dto.response.AssignSubmissionFileResponseDTO;
import com.onschool.demo.infrastructure.persistance.entity.AssignSubmissionFile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssignSubmissionFileMapper {

    AssignSubmissionFileResponseDTO toDTO(AssignSubmissionFile entity);
}

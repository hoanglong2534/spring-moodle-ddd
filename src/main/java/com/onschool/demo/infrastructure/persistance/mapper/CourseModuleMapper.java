package com.onschool.demo.infrastructure.persistance.mapper;

import com.onschool.demo.application.dto.response.CourseModuleResponseDTO;
import com.onschool.demo.infrastructure.persistance.entity.CourseModules;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ModuleMapper.class, CourseMapper.class})
public interface CourseModuleMapper {

    CourseModuleResponseDTO toDTO(CourseModules courseModules);
}
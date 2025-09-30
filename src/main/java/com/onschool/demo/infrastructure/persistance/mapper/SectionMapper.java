package com.onschool.demo.infrastructure.persistance.mapper;

import com.onschool.demo.application.dto.response.SectionResponseDTO;
import com.onschool.demo.infrastructure.persistance.entity.CourseSections;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ModuleMapper.class)
public interface SectionMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "summary", target = "summary")
    @Mapping(source = "courseModules", target = "modules")
    SectionResponseDTO toDTO(CourseSections section);
}

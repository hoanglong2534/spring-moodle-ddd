package com.onschool.demo.infrastructure.persistance.mapper;

import com.onschool.demo.domain.model.SectionDomain;
import com.onschool.demo.infrastructure.persistance.entity.CourseSections;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ModuleMapper.class})
public interface SectionDomainMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "summary", target = "summary")
    @Mapping(source = "courseModules", target = "modules")
    SectionDomain toDomain(CourseSections section);

    List<SectionDomain> toDomainList(List<CourseSections> sections);
}

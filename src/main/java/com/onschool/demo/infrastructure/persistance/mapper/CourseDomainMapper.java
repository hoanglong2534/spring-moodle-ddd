package com.onschool.demo.infrastructure.persistance.mapper;

import com.onschool.demo.application.dto.response.CourseDetailResponseDTO;
import com.onschool.demo.domain.model.CourseDomain;
import com.onschool.demo.infrastructure.persistance.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {SectionDomainMapper.class, SectionResponseMapper.class})
public interface CourseDomainMapper {

    CourseDomain toDomain(Course course);
    Course toEntity(CourseDomain courseDomain);

    @Mapping(source = "fullname", target = "name")
    @Mapping(source = "summary", target = "description")
    @Mapping(source = "courseSections", target = "sections")
    CourseDetailResponseDTO toCourseDetailResponseDTO(CourseDomain courseDomain);
}

package com.onschool.demo.infrastructure.persistance.mapper;

import com.onschool.demo.application.dto.response.CourseDetailResponseDTO;
import com.onschool.demo.application.dto.response.CourseResponseDTO;
import com.onschool.demo.infrastructure.persistance.entity.Course;
import com.onschool.demo.infrastructure.persistance.entity.UserEnrolments;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring", uses = SectionMapper.class)
public interface CourseMapper {

    CourseResponseDTO toDTO(Course course);
    Course toEntity(CourseResponseDTO courseResponseDTO);

    @Mapping(source = "enrol.course.id", target = "id")
    @Mapping(source = "enrol.course.fullname", target = "fullname")
    @Mapping(source = "enrol.course.summary", target = "summary")
    @Mapping(source = "enrol.course.shortname", target = "shortName")
    @Mapping(source = "enrol.course.startdate", target = "startdate")
    @Mapping(source = "enrol.course.enddate", target = "enddate")
    CourseResponseDTO toCourseResponseDTO(UserEnrolments userEnrolments);

    @Mapping(source = "fullname", target = "name")
    @Mapping(source = "summary", target = "description")
    @Mapping(source = "courseSections", target = "sections")
    CourseDetailResponseDTO toCourseDetailResponseDTO(Course course);
}

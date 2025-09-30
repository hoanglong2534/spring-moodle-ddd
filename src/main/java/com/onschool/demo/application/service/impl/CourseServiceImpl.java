package com.onschool.demo.application.service.impl;

import com.onschool.demo.application.dto.response.CourseDetailResponseDTO;
import com.onschool.demo.application.service.CourseService;
import com.onschool.demo.infrastructure.persistance.entity.Course;
import com.onschool.demo.infrastructure.persistance.mapper.CourseMapper;
import com.onschool.demo.infrastructure.persistance.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseDetailResponseDTO getCourseDetailById(Long courseId) {
       Course course = courseRepository
               .findById(courseId)
               .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));

       return courseMapper.toCourseDetailResponseDTO(course);
    }
}

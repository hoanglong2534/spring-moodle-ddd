package com.onschool.demo.application.service;

import com.onschool.demo.application.dto.response.CourseDetailResponseDTO;

public interface CourseService {
    CourseDetailResponseDTO getCourseDetailById(Long courseId);
}

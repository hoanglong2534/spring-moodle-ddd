package com.onschool.demo.application.service;

import com.onschool.demo.application.dto.response.CourseResponseDTO;

import java.util.List;

public interface UserEnrolmentService {
    List<CourseResponseDTO> getCoursesByUser_Id(Long userId);
}

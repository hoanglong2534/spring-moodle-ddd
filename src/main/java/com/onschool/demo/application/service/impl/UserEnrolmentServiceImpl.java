package com.onschool.demo.application.service.impl;

import com.onschool.demo.application.dto.response.CourseResponseDTO;
import com.onschool.demo.application.service.UserEnrolmentService;
import com.onschool.demo.infrastructure.persistance.mapper.CourseMapper;
import com.onschool.demo.infrastructure.persistance.repository.UserEnrolmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class UserEnrolmentServiceImpl implements UserEnrolmentService {

    private final UserEnrolmentRepository userEnrolmentRepository;
    private final CourseMapper courseMapper;

    @Override
    public List<CourseResponseDTO> getCoursesByUser_Id(Long userId) {
        return userEnrolmentRepository.findByUser_Id(userId).stream()
                .map(courseMapper::toCourseResponseDTO)
                .collect(Collectors.toList());
    }

}


package com.onschool.demo.application.service.impl;

import com.onschool.demo.application.dto.response.CourseDetailResponseDTO;
import com.onschool.demo.application.service.CourseService;
import com.onschool.demo.domain.model.CourseDomain;
import com.onschool.demo.domain.repository.CourseDomainRepository;
import com.onschool.demo.infrastructure.persistance.entity.Course;
import com.onschool.demo.infrastructure.persistance.mapper.CourseDomainMapper;
import com.onschool.demo.infrastructure.persistance.mapper.CourseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseDomainRepository courseDomainRepository;
    private final CourseDomainMapper courseDomainMapper;

    @Override
    public CourseDetailResponseDTO getCourseDetailById(Long courseId) {
        CourseDomain courseDomain = courseDomainRepository.findById(courseId).orElse(null);
        if (courseDomain == null) {
            return null;
        }
        return courseDomainMapper.toCourseDetailResponseDTO(courseDomain);
    }

}

package com.onschool.demo.application.service.impl;

import com.onschool.demo.application.dto.request.CourseModulesCompletionRequestDTO;
import com.onschool.demo.application.dto.response.CourseModulesCompletionResponseDTO;
import com.onschool.demo.application.service.CourseModulesCompletionService;
import com.onschool.demo.infrastructure.persistance.entity.CourseModulesCompletion;
import com.onschool.demo.infrastructure.persistance.mapper.CourseModulesCompletionMapper;
import com.onschool.demo.infrastructure.persistance.repository.CourseModulesCompletionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseModulesCompletionServiceImpl implements CourseModulesCompletionService {

    private final CourseModulesCompletionRepository courseModulesCompletionRepository;
    private final CourseModulesCompletionMapper courseModulesCompletionMapper;

    @Override
    public CourseModulesCompletionResponseDTO findByUserIdAndModuleId(Long userId, Long courseId) {
        CourseModulesCompletion completion = courseModulesCompletionRepository
                .findByUserIdAndCourseModulesId(userId, courseId).orElse(null);
        if (completion == null) {
            return null;
        }
        return courseModulesCompletionMapper.toDTO(completion);
    }

    @Override
    public Long countCompletedModulesByUserId(Long userId) {
        return courseModulesCompletionRepository.countByUserId(userId);
    }

    @Override
    public void markModuleAsCompleted(Long userId, Long moduleId) {
        CourseModulesCompletion completion = courseModulesCompletionRepository
                .findByUserIdAndCourseModulesId(userId, moduleId)
                .orElse(new CourseModulesCompletion());

        completion.getUser().setId(userId);
        completion.getCourseModules().setId(moduleId);
        completion.setCompletionstate(1);
        completion.setViewed(1);
        completion.setTimemodified(System.currentTimeMillis() / 1000L);

        courseModulesCompletionRepository.save(completion);
    }


    @Override
    public boolean CheckModuleCompleted(Long userId, Long moduleId) {
        return courseModulesCompletionRepository.existsByUserIdAndCourseModulesId(userId, moduleId);
    }
}

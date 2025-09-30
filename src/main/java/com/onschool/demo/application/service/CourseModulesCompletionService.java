package com.onschool.demo.application.service;

import com.onschool.demo.application.dto.response.CourseModulesCompletionResponseDTO;

public interface CourseModulesCompletionService {
    CourseModulesCompletionResponseDTO findByUserIdAndModuleId(Long userId, Long moduleId);

    Long countCompletedModulesByUserId(Long userId);

    void markModuleAsCompleted(Long userId, Long moduleId);

    boolean CheckModuleCompleted(Long userId, Long moduleId);

}

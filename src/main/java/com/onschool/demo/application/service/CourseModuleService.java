package com.onschool.demo.application.service;


import com.onschool.demo.application.dto.response.ModuleResponseDTO;

import java.util.List;

public interface CourseModuleService {
    List<ModuleResponseDTO> getModuleDetailByCourseAndModule(Long courseId, Long moduleId);
}

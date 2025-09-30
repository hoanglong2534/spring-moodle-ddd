package com.onschool.demo.application.service.impl;

import com.onschool.demo.application.dto.response.ModuleResponseDTO;
import com.onschool.demo.application.service.CourseModuleService;
import com.onschool.demo.infrastructure.persistance.entity.CourseModules;
import com.onschool.demo.infrastructure.persistance.mapper.ModuleMapper;
import com.onschool.demo.infrastructure.persistance.repository.CourseModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseModuleServiceImpl implements CourseModuleService {

    private final CourseModuleRepository courseModuleRepository;
    private final ModuleMapper moduleMapper;

    @Override
    public List<ModuleResponseDTO> getModuleDetailByCourseAndModule(Long courseId, Long moduleId) {
        List<CourseModules> courseModulesList = courseModuleRepository
                .findByCourseEntityIdAndModulesId(courseId, moduleId);

        return courseModulesList.stream().map(moduleMapper::toModuleResponseDTO).collect(Collectors.toList());
    }
}

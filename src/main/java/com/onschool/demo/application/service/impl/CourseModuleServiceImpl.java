package com.onschool.demo.application.service.impl;

import com.onschool.demo.application.dto.response.ModuleResponseDTO;
import com.onschool.demo.application.service.CourseModuleService;
import com.onschool.demo.domain.model.CourseModuleDomain;
import com.onschool.demo.domain.repository.CourseModuleDomainRepository;
import com.onschool.demo.infrastructure.persistance.entity.CourseModules;
import com.onschool.demo.infrastructure.persistance.mapper.CourseModuleDomainMapper;
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

    private final CourseModuleDomainRepository courseModuleDomainRepository;
    private final CourseModuleDomainMapper courseModuleDomainMapper;

    @Override
    public List<ModuleResponseDTO> getModuleDetailByCourseAndModule(Long courseId, Long moduleId) {
        List<CourseModuleDomain> courseModuleDomainList = courseModuleDomainRepository
                .getModulesByCourseAndModule(courseId, moduleId);

        List<ModuleResponseDTO> moduleResponseDTOList = new ArrayList<>();

        for(CourseModuleDomain courseModuleDomain : courseModuleDomainList) {
            ModuleResponseDTO moduleResponseDTO = courseModuleDomainMapper.toModuleDTO(courseModuleDomain);
            moduleResponseDTOList.add(moduleResponseDTO);
        }

        return moduleResponseDTOList;
    }
}

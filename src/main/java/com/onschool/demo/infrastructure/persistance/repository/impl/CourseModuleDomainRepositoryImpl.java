package com.onschool.demo.infrastructure.persistance.repository.impl;

import com.onschool.demo.domain.model.CourseModuleDomain;
import com.onschool.demo.domain.repository.CourseModuleDomainRepository;
import com.onschool.demo.infrastructure.persistance.entity.CourseModules;
import com.onschool.demo.infrastructure.persistance.mapper.CourseModuleDomainMapper;
import com.onschool.demo.infrastructure.persistance.repository.CourseModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CourseModuleDomainRepositoryImpl implements CourseModuleDomainRepository {

    private final CourseModuleRepository courseModuleRepository;
    private final CourseModuleDomainMapper courseModuleDomainMapper;
    @Override
    public List<CourseModuleDomain> getModulesByCourseAndModule(Long courseId, Long moduleId) {
        List<CourseModuleDomain> courseModuleDomainList = new ArrayList<>();

        List<CourseModules> courseModulesList = courseModuleRepository.findByCourseEntityIdAndModulesId(courseId, moduleId);

        for(CourseModules courseModules : courseModulesList){
            CourseModuleDomain courseModuleDomain = courseModuleDomainMapper.toDomain(courseModules);
            courseModuleDomainList.add(courseModuleDomain);
        }

        return courseModuleDomainList;

    }
}

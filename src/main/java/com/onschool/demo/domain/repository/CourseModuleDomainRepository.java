package com.onschool.demo.domain.repository;

import com.onschool.demo.domain.model.CourseModuleDomain;
import com.onschool.demo.domain.model.ModuleDomain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseModuleDomainRepository {
    List<CourseModuleDomain> getModulesByCourseAndModule(Long courseId, Long moduleId);

}

package com.onschool.demo.infrastructure.persistance.repository;

import com.onschool.demo.infrastructure.persistance.entity.CourseModules;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseModuleRepository extends JpaRepository<CourseModules, Long> {
    List<CourseModules> findByCourseEntityIdAndModulesId(Long courseId, Long moduleId);
}

package com.onschool.demo.infrastructure.persistance.repository;

import com.onschool.demo.infrastructure.persistance.entity.CourseModulesCompletion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseModulesCompletionRepository extends JpaRepository<CourseModulesCompletion, Long> {

    Optional<CourseModulesCompletion> findByUserIdAndCourseModulesId(Long userId, Long courseModulesId);

    Long countByUserId(Long userId);

    Boolean existsByUserIdAndCourseModulesId(Long userId, Long courseModulesId);


}

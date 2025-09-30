package com.onschool.demo.infrastructure.persistance.repository;

import com.onschool.demo.infrastructure.persistance.entity.Course;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @EntityGraph(attributePaths = {"courseSections.courseModules"})
    Optional<Course> findById(Long courseId);

}

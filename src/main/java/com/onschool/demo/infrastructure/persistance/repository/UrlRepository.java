package com.onschool.demo.infrastructure.persistance.repository;

import com.onschool.demo.infrastructure.persistance.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Url findByIdAndCourseModules_Id(Long id, Long courseId);
}

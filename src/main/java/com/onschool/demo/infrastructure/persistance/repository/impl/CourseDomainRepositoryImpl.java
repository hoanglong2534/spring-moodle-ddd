package com.onschool.demo.infrastructure.persistance.repository.impl;

import com.onschool.demo.domain.model.CourseDomain;
import com.onschool.demo.domain.repository.CourseDomainRepository;
import com.onschool.demo.infrastructure.persistance.mapper.CourseDomainMapper;
import com.onschool.demo.infrastructure.persistance.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CourseDomainRepositoryImpl implements CourseDomainRepository {

    private final CourseDomainMapper courseDomainMapper;
    private final CourseRepository courseRepository;

    @Override
    public Optional<CourseDomain> findById(Long id) {
        return courseRepository.findById(id).map(courseDomainMapper::toDomain);
    }
}

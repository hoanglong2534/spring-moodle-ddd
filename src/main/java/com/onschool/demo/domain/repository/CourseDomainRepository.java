package com.onschool.demo.domain.repository;


import com.onschool.demo.domain.model.CourseDomain;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseDomainRepository {
    Optional<CourseDomain> findById(Long id);
}

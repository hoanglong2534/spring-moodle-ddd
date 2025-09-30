package com.onschool.demo.domain.repository;

import com.onschool.demo.domain.model.AssignDomain;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignDomainRepository {
    AssignDomain findById(Long id);
}

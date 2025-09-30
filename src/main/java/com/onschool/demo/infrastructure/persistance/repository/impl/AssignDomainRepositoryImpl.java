package com.onschool.demo.infrastructure.persistance.repository.impl;

import com.onschool.demo.domain.model.AssignDomain;
import com.onschool.demo.domain.repository.AssignDomainRepository;
import com.onschool.demo.infrastructure.persistance.entity.Assign;

import com.onschool.demo.infrastructure.persistance.mapper.AssignDomainMapper;
import com.onschool.demo.infrastructure.persistance.repository.AssignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AssignDomainRepositoryImpl implements AssignDomainRepository {

    private final AssignRepository assignRepository;
    private final AssignDomainMapper assignDomainMapper;

    @Override
    public AssignDomain findById(Long id) {
        Assign assignEntity = assignRepository.findById(id).orElse(null);
        if (assignEntity == null) {
            return null;
        }
        return assignDomainMapper.toDomain(assignEntity);

    }
}

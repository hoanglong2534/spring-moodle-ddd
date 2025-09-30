package com.onschool.demo.application.service.impl;

import com.onschool.demo.application.dto.response.AssignResponseDTO;
import com.onschool.demo.application.service.AssignService;
import com.onschool.demo.domain.model.AssignDomain;
import com.onschool.demo.domain.repository.AssignDomainRepository;
import com.onschool.demo.infrastructure.persistance.mapper.AssignDomainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AssignServiceImpl implements AssignService {

    private final AssignDomainRepository assignDomainRepository;
    private final AssignDomainMapper assignDomainMapper;

    @Override
    public AssignResponseDTO getAssignById(Long assignId) {
        AssignDomain assign = assignDomainRepository.findById(assignId);
        if (assign == null) {
            return null;
        }
        return assignDomainMapper.toDTO(assign);
    }
}

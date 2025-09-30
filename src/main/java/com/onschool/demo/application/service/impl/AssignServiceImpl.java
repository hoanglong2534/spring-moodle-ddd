package com.onschool.demo.application.service.impl;

import com.onschool.demo.application.dto.response.AssignResponseDTO;
import com.onschool.demo.application.service.AssignService;
import com.onschool.demo.infrastructure.persistance.entity.Assign;
import com.onschool.demo.infrastructure.persistance.mapper.AssignMapper;
import com.onschool.demo.infrastructure.persistance.repository.AssignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AssignServiceImpl implements AssignService {

    private final AssignRepository assignRepository;
    private final AssignMapper assignMapper;

    @Override
    public AssignResponseDTO getAssignById(Long assignId) {
        Assign assign = assignRepository.findById(assignId).orElse(null);
        if (assign == null) {
            return null;
        }
        return assignMapper.toDTO(assign);
    }
}

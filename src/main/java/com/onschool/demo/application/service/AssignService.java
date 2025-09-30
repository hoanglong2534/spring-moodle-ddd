package com.onschool.demo.application.service;

import com.onschool.demo.application.dto.response.AssignResponseDTO;

public interface AssignService {
    AssignResponseDTO getAssignById(Long assignId);

}

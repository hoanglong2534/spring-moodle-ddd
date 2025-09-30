package com.onschool.demo.presentation.restcontroller;

import com.onschool.demo.application.dto.response.AssignResponseDTO;
import com.onschool.demo.application.service.AssignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/assign")
public class AssignController {

    private final AssignService assignService;

    @GetMapping("/{id}")
    public AssignResponseDTO getAssignById(@PathVariable Long id) {
        return assignService.getAssignById(id);
    }
}

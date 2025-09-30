package com.onschool.demo.domain.model;

import com.onschool.demo.application.dto.response.ModuleResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectionDomain {
    private Long id;
    private String name;
    private String summary;
    private List<ModuleResponseDTO> modules;
}

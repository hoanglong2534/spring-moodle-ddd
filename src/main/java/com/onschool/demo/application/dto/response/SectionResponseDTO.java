package com.onschool.demo.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectionResponseDTO {
    private Long id;
    private String name;
    private String summary;
    private List<ModuleResponseDTO> modules;
}

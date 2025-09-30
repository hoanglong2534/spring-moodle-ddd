package com.onschool.demo.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseModuleResponseDTO {
    private Long id;
    private String name;
    private String type;
    private String urlName;
    private String details;
    private ModuleResponseDTO modules;
    private CourseResponseDTO courses;
}

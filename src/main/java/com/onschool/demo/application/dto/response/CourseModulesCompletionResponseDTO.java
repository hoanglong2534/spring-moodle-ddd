package com.onschool.demo.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseModulesCompletionResponseDTO {
    private Long id;
    private Integer completionstate;
    private Integer viewed;
    private Long timemodified;
    private UserResponseDTO user;
    private CourseModuleResponseDTO coursemodule;
}

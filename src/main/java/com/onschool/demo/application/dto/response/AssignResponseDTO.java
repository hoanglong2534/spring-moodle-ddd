package com.onschool.demo.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignResponseDTO {
    private Long id;
    private String name;
    private String intro;
    private Long grade;
    private Long teamsubmission;
    private Integer timemodified;
    private Long maxattempts;
    private List<AssignSubmissionsResponseDTO> assignSubmission;

}

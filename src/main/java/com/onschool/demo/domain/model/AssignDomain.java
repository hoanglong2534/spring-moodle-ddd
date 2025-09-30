package com.onschool.demo.domain.model;

import com.onschool.demo.application.dto.response.AssignSubmissionsResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignDomain {
    private Long id;
    private String name;
    private String intro;
    private Long grade;
    private Long teamsubmission;
    private Integer timemodified;
    private Long maxattempts;
    private List<AssignSubmissionsResponseDTO> assignSubmission;

}

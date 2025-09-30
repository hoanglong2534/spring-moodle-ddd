package com.onschool.demo.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignSubmissionsResponseDTO {
    private Long id;
    private Long userid;
    private Long teacher;
    private Long timecreated;
    private Long timemodified;
    private Long numfiles;
    private String submissioncomment;
    private Integer mailed;
    private List<AssignSubmissionFileResponseDTO> files;
}

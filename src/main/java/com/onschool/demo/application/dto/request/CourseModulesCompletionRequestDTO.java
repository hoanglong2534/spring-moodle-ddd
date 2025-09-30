package com.onschool.demo.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseModulesCompletionRequestDTO {
    private Long userid;
    private Long coursemoduleid;
    private Long completionstate;
    private Long viewed;
    private Long timemodified;

}

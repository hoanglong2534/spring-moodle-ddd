package com.onschool.demo.domain.model;

import com.onschool.demo.application.dto.response.ModuleResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseModuleDomain {
    private Long id;
    private String name;
    private String type;
    private String urlName;
    private Long instanceId;
    private Integer visible;
    private Long cron;
    private Long lastcron;
    private String search;
    private ModuleResponseDTO modules;
    private CourseDomain courses;
}

package com.onschool.demo.domain.course;

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
    private String url;
}

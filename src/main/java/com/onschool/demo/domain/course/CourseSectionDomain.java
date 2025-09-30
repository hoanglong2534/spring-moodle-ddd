package com.onschool.demo.domain.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseSectionDomain {
    private Long id;
    private String name;
    private String summary;
    private List<CourseModuleDomain> modules;
}

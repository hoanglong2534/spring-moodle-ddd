package com.onschool.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDomain {
    private Long id;
    private String fullname;
    private String shortname;
    private String summary;
    private List<SectionDomain> courseSections;
}

package com.onschool.demo.domain.enrollment;

import com.onschool.demo.domain.user.User;
import com.onschool.demo.domain.course.CourseDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnrolDomain {
    private Long id;
    private User student;
    private CourseDomain course;
    private String enrolMethod;
}

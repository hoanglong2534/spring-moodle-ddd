package com.onschool.demo.domain.user;

import com.onschool.demo.domain.enrollment.EnrolDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private Role role;

    List<EnrolDomain> enrollments = new ArrayList();


}

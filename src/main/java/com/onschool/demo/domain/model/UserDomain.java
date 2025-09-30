package com.onschool.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDomain {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String department;
    private String address;
    private String city;
    private String country;
}

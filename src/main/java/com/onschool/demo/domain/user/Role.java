package com.onschool.demo.domain.user;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Long id;
    private String name;
    private String shortName;
    private String description;
    private Long sortOrder;
    private Archetype archetype;

    public boolean checkStudent(){
        return this.archetype == Archetype.STUDENT;
    }

    public boolean checkTeacher(){
        return this.archetype == Archetype.TEACHER;
    }

    public boolean checkAdmin(){
        return this.archetype == Archetype.ADMIN;
    }

}

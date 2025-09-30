package com.onschool.demo.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDomain {
    private Long id;
    private String name;
    private String questiontext;
    private String questiontextformat;
    private String generalfeedback;
    private String defaultmark;
    private String penalty;
    private String qtype;
    private Long length;
    private Long timecreated;
    private Long timemodified;

}

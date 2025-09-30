package com.onschool.demo.domain.model;

import com.onschool.demo.application.dto.response.QuizSlotResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizDomain {
    private Long id;
    private String name;
    private String intro;
    private Long timeopen;
    private Long timeclose;
    private Integer timelimit;
    private Long attempts;
    private Integer attemptonlast;
    private Long timecreated;
    private String password;
    private List<QuizSlotDomain> quizSlotsList;
    private List<QuizAttemptsDomain> quizAttemptsList;
}

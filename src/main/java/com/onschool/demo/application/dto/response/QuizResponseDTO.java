package com.onschool.demo.application.dto.response;

import com.onschool.demo.infrastructure.persistance.entity.QuizAttempts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizResponseDTO {
    private String name;
    private String intro;
    private Long timeopen;
    private Long timeclose;
    private Integer timelimit;
    private Long attempts;
    private Integer attemptonlast;
    private Long timecreated;
    private String password;
    private List<QuizSlotResponseDTO> quizSlotsList;
    private List<QuizAttemptsResponseDTO> quizAttemptsList;
}

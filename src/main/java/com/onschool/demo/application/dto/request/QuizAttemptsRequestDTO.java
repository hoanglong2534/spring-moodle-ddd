package com.onschool.demo.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizAttemptsRequestDTO {
    private Long quizId;
    private Long userId;
    private Integer currentpage;
}

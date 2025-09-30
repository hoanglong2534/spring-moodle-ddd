package com.onschool.demo.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizSlotResponseDTO {
    private Long id;
    private Long slot;
    private Long page;
    private String requireprevious;
    private BigDecimal maxmark;
    private QuestionResponseDTO question;
}


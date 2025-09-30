package com.onschool.demo.domain.model;

import com.onschool.demo.application.dto.response.QuestionResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizSlotDomain {
    private Long id;
    private Long slot;
    private Long page;
    private String requireprevious;
    private BigDecimal maxmark;
    private QuestionDomain question;
}

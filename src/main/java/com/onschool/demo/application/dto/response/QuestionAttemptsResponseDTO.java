package com.onschool.demo.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAttemptsResponseDTO {
    private Long id;
    private Long questionusageid;
    private Long slot;
    private String behaviour;
    private BigDecimal maxmark;
    private String questionsummary;
    private String rightanswer;
    private String responsesummary;
    private Long timemodified;
}

package com.onschool.demo.application.dto.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizAttemptsResponseDTO {
    private UserResponseDTO user;
    private Long attempt;
    private Long uniqueid;
    private String layout;
    private Integer preview;
    private Long timestart;
    private Long timefinish;
    private Long timemodified;
    private Long timemodifiedoffline;
    private QuizResponseDTO quiz;
    private List<QuestionAttemptsResponseDTO> questionAttemptsResponseDTOList;

}
package com.onschool.demo.infrastructure.persistance.mapper;

import com.onschool.demo.application.dto.response.QuizResponseDTO;
import com.onschool.demo.infrastructure.persistance.entity.Quiz;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {QuizSlotMapper.class, QuizAttemptsMapper.class, CourseModuleMapper.class})
public interface QuizMapper {

    QuizResponseDTO toDTO(Quiz quiz);

    Quiz toEntity(QuizResponseDTO quizResponseDTO);

}

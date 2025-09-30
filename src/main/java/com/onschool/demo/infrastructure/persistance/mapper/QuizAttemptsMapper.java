package com.onschool.demo.infrastructure.persistance.mapper;

import com.onschool.demo.application.dto.request.QuizAttemptsRequestDTO;
import com.onschool.demo.application.dto.response.QuizAttemptsResponseDTO;
import com.onschool.demo.infrastructure.persistance.entity.QuizAttempts;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, QuestionAttemptsMapper.class})
public interface QuizAttemptsMapper {
    @Mapping(source = "user", target = "user")
    @Mapping(source = "questionAttemptsList", target = "questionAttemptsResponseDTOList")
    QuizAttemptsResponseDTO toDTO(QuizAttempts quizAttempts);

    QuizAttempts toEntity(QuizAttemptsRequestDTO quizAttempts);
}
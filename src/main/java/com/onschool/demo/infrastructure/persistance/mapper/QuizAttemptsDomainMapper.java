package com.onschool.demo.infrastructure.persistance.mapper;

import com.onschool.demo.application.dto.response.QuizAttemptsResponseDTO;
import com.onschool.demo.domain.model.QuizAttemptsDomain;
import com.onschool.demo.infrastructure.persistance.entity.QuizAttempts;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuizAttemptsDomainMapper {

    QuizAttemptsDomain toDomain(QuizAttempts quizAttempts);

    QuizAttemptsResponseDTO toDTO(QuizAttemptsDomain quizAttemptsDomain);
}

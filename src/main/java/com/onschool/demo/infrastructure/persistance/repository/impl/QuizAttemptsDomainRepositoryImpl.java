package com.onschool.demo.infrastructure.persistance.repository.impl;

import com.onschool.demo.domain.model.QuizAttemptsDomain;
import com.onschool.demo.domain.repository.QuizAttemptsDomainRepository;
import com.onschool.demo.infrastructure.persistance.entity.QuizAttempts;
import com.onschool.demo.infrastructure.persistance.mapper.QuizAttemptsDomainMapper;
import com.onschool.demo.infrastructure.persistance.repository.QuizAttemptsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QuizAttemptsDomainRepositoryImpl implements QuizAttemptsDomainRepository {

    private final QuizAttemptsRepository quizAttemptsRepository;
    private final QuizAttemptsDomainMapper quizAttemptsDomainMapper;

    @Override
    public QuizAttemptsDomain getQuizAttemptById(Long id) {
        QuizAttempts quizAttempts = quizAttemptsRepository.findById(id).orElse(null);
        if (quizAttempts == null) {
            return null;
        }
        return quizAttemptsDomainMapper.toDomain(quizAttempts);
    }
}

package com.onschool.demo.application.service.impl;

import com.onschool.demo.application.dto.response.QuizAttemptsResponseDTO;
import com.onschool.demo.application.service.QuizAttemptsService;
import com.onschool.demo.domain.model.QuizAttemptsDomain;
import com.onschool.demo.domain.repository.QuizAttemptsDomainRepository;
import com.onschool.demo.infrastructure.persistance.mapper.QuizAttemptsDomainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizAttemptsServiceImpl implements QuizAttemptsService {

    private final QuizAttemptsDomainRepository quizAttemptsDomainRepository;
    private final QuizAttemptsDomainMapper quizAttemptsDomainMapper;

    @Override
    public QuizAttemptsResponseDTO getQuizAttemptsById(Long quizAttemptsId) {
        QuizAttemptsDomain quizAttemptDomain =  quizAttemptsDomainRepository.getQuizAttemptById(quizAttemptsId);
        return quizAttemptsDomainMapper.toDTO(quizAttemptDomain);

    }

}

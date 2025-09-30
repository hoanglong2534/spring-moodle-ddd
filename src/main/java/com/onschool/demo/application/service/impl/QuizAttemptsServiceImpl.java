package com.onschool.demo.application.service.impl;

import com.onschool.demo.application.dto.request.QuizAttemptsRequestDTO;
import com.onschool.demo.application.dto.response.QuizAttemptsResponseDTO;
import com.onschool.demo.application.service.QuizAttemptsService;
import com.onschool.demo.infrastructure.persistance.entity.Quiz;
import com.onschool.demo.infrastructure.persistance.entity.QuizAttempts;
import com.onschool.demo.infrastructure.persistance.entity.User;
import com.onschool.demo.infrastructure.persistance.mapper.QuizAttemptsMapper;
import com.onschool.demo.infrastructure.persistance.repository.QuizAttemptsRepository;
import com.onschool.demo.infrastructure.persistance.repository.QuizRepository;
import com.onschool.demo.infrastructure.persistance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizAttemptsServiceImpl implements QuizAttemptsService {

    private final QuizAttemptsRepository quizAttemptsRepository;
    private final QuizRepository quizRepository;
    private final UserRepository userRepository;
    private final QuizAttemptsMapper quizAttemptsMapper;

    @Override
    public QuizAttemptsResponseDTO getQuizAttemptsById(Long quizAttemptsId) {
        QuizAttempts quizAttempts = quizAttemptsRepository.findById(quizAttemptsId).get();
        if (quizAttempts == null) {
            return null;
        }
        return quizAttemptsMapper.toDTO(quizAttempts);
    }

}

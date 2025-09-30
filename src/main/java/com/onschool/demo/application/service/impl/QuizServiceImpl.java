package com.onschool.demo.application.service.impl;

import com.onschool.demo.application.dto.response.QuizResponseDTO;
import com.onschool.demo.application.service.QuizService;
import com.onschool.demo.infrastructure.persistance.entity.Quiz;
import com.onschool.demo.infrastructure.persistance.mapper.QuizMapper;
import com.onschool.demo.infrastructure.persistance.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;

    @Override
    public QuizResponseDTO getQuizByIdAndCourse(Long quizId, Long courseId) {
        Quiz quiz = quizRepository.findByIdAndCourseModules_Id(quizId, courseId).orElse(null);
        if (quiz == null) {
            return null;
        }
        return quizMapper.toDTO(quiz);
    }
}

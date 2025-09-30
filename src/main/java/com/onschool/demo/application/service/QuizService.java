package com.onschool.demo.application.service;

import com.onschool.demo.application.dto.response.QuizResponseDTO;

public interface QuizService {
    QuizResponseDTO getQuizByIdAndCourse(Long quizId, Long courseId);
}

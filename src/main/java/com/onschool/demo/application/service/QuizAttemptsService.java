package com.onschool.demo.application.service;

import com.onschool.demo.application.dto.response.QuizAttemptsResponseDTO;


public interface QuizAttemptsService {
    QuizAttemptsResponseDTO getQuizAttemptsById(Long quizAttemptsId);

}

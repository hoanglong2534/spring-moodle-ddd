package com.onschool.demo.presentation.restcontroller;


import com.onschool.demo.application.dto.request.QuizAttemptsRequestDTO;
import com.onschool.demo.application.dto.response.QuizAttemptsResponseDTO;
import com.onschool.demo.application.service.QuizAttemptsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/quiz-attempts")
public class QuizAttemptsController {

    private final QuizAttemptsService quizAttemptsService;

    @GetMapping("/{quizAttemptsId}")
    public QuizAttemptsResponseDTO getQuizAttemptsById(@PathVariable Long quizAttemptsId) {
       return quizAttemptsService.getQuizAttemptsById(quizAttemptsId);
    }


}

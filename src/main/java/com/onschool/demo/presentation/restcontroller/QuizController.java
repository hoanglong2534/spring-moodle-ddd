package com.onschool.demo.presentation.restcontroller;

import com.onschool.demo.application.dto.response.QuizResponseDTO;
import com.onschool.demo.application.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/{quizid}/course/{courseid}")
    public QuizResponseDTO getQuizById(@PathVariable Long quizid, @PathVariable Long courseid) {
        return quizService.getQuizByIdAndCourse(quizid, courseid);
    }
}

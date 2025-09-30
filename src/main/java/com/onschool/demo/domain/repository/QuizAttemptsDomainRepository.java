package com.onschool.demo.domain.repository;

import com.onschool.demo.domain.model.QuizAttemptsDomain;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizAttemptsDomainRepository {
    QuizAttemptsDomain getQuizAttemptById(Long id);
}

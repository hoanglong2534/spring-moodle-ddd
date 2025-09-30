package com.onschool.demo.infrastructure.persistance.repository;

import com.onschool.demo.infrastructure.persistance.entity.UserEnrolments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserEnrolmentRepository extends JpaRepository<UserEnrolments, Long> {
    List<UserEnrolments> findByUser_Id(Long id);
}

package com.onschool.demo.presentation.restcontroller;

import com.onschool.demo.application.dto.response.CourseResponseDTO;
import com.onschool.demo.application.service.UserEnrolmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/enrolments")
public class UserEnrolmentController {

    private final UserEnrolmentService userEnrolmentService;

    @GetMapping("/{id}/courses")
    public List<CourseResponseDTO> getUserCourses(@PathVariable Long id) {
        return userEnrolmentService.getCoursesByUser_Id(id);
    }

}

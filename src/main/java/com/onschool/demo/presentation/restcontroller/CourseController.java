package com.onschool.demo.presentation.restcontroller;

import com.onschool.demo.application.dto.response.CourseDetailResponseDTO;
import com.onschool.demo.application.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/{id}/detail")
    public CourseDetailResponseDTO getCourseDetail(@PathVariable Long id) {
        return courseService.getCourseDetailById(id);
    }
}

package com.onschool.demo.presentation.restcontroller;

import com.onschool.demo.application.dto.response.CourseModulesCompletionResponseDTO;
import com.onschool.demo.application.service.CourseModulesCompletionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course-modules-completion")
public class CourseModulesCompletionController {

    private final CourseModulesCompletionService courseModulesCompletionService;

    @GetMapping("/find/{userId}/{courseId}")
    public  CourseModulesCompletionResponseDTO findByUserIdAndModuleId(@PathVariable Long userId, @PathVariable Long courseId) {
        return courseModulesCompletionService.findByUserIdAndModuleId(userId,courseId);
    }

    @GetMapping("/count/{userid}" )
    public Long countCompletedModulesByUserId(@PathVariable Long userid) {
        return courseModulesCompletionService.countCompletedModulesByUserId(userid);
    }

    @GetMapping("/mark-complete/{userId}/{courseId}" )
    public void markModuleAsComplete(@PathVariable Long userId, @PathVariable Long courseId) {
         courseModulesCompletionService.markModuleAsCompleted(userId, courseId);
    }

    @GetMapping("/exists/{userId}/{courseId}" )
    public boolean existsByUserIdAndCourseId(@PathVariable Long userId, @PathVariable Long courseId) {
        return courseModulesCompletionService.CheckModuleCompleted(userId, courseId);
    }

}

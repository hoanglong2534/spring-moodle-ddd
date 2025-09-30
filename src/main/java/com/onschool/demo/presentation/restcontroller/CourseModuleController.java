package com.onschool.demo.presentation.restcontroller;

import com.onschool.demo.application.dto.response.ModuleResponseDTO;
import com.onschool.demo.application.service.CourseModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/course-modules")
@RequiredArgsConstructor
public class CourseModuleController {

    private final CourseModuleService courseModuleService;

    @GetMapping("/course/{courseId}/module/{moduleId}")
    public List<ModuleResponseDTO> assignModuleToCourse(@PathVariable Long courseId, @PathVariable Long moduleId) {
        return courseModuleService.getModuleDetailByCourseAndModule(courseId, moduleId);
    }

}

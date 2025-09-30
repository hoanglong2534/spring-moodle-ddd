package com.onschool.demo.infrastructure.persistance.mapper;

import com.onschool.demo.application.dto.response.ModuleResponseDTO;
import com.onschool.demo.infrastructure.persistance.entity.CourseModules;
import com.onschool.demo.infrastructure.persistance.entity.Assign;
import com.onschool.demo.infrastructure.persistance.entity.Quiz;
import com.onschool.demo.infrastructure.persistance.entity.Url;
import com.onschool.demo.infrastructure.persistance.repository.AssignRepository;
import com.onschool.demo.infrastructure.persistance.repository.QuizRepository;
import com.onschool.demo.infrastructure.persistance.repository.UrlRepository;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ModuleMapper {

    @Autowired
    protected AssignRepository assignRepository;

    @Autowired
    protected QuizRepository quizRepository;

    @Autowired
    protected UrlRepository urlRepository;

    @Mapping(source = "id", target = "id")
    @Mapping(source = "modules.name", target = "name")
    @Mapping(target = "urlName", expression = "java(\"mod/\" + courseModules.getModules().getName() + \"/view.php?id=\" + courseModules.getId())")
    @Mapping(source = "modules.name", target = "moduleType")
    @Mapping(source = "modules.cron", target = "cron")
    @Mapping(source = "visible", target = "visible")
    @Mapping(source = "id", target = "instanceId")
    @Mapping(source = "modules.lastcron", target = "lastcron")
    @Mapping(source = "modules.search", target = "search")
    public abstract ModuleResponseDTO toModuleResponseDTO(CourseModules courseModules);

    @AfterMapping
    protected void setDetails(CourseModules courseModules, @MappingTarget ModuleResponseDTO dto) {
        String moduleName = courseModules.getModules().getName();
        String details = "";

        if ("assign".equals(moduleName)) {
            details = assignRepository.findById(courseModules.getInstance())
                    .map(Assign::getIntro).orElse("");
        } else if ("quiz".equals(moduleName)) {
            details = quizRepository.findById(courseModules.getInstance())
                    .map(Quiz::getIntro).orElse("");
        } else if ("url".equals(moduleName)) {
            details = urlRepository.findById(courseModules.getInstance())
                    .map(Url::getIntro).orElse("");
        }

        dto.setDetails(details);
    }
}

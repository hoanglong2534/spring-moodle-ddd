package com.onschool.demo.infrastructure.persistance.mapper;

import com.onschool.demo.application.dto.response.ModuleResponseDTO;
import com.onschool.demo.domain.model.CourseModuleDomain;
import com.onschool.demo.infrastructure.persistance.entity.CourseModules;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface CourseModuleDomainMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "modules.name", target = "type")        // Loại module (assignment, quiz...)
    @Mapping(source = "modules.name", target = "name")        // Nếu muốn name = tên module
    @Mapping(source = "url.externalurl", target = "urlName")  // URL từ bảng url
    @Mapping(source = "instance", target = "instanceId")      // Instance trong mdl_course_modules
    @Mapping(source = "visible", target = "visible")          // Visible từ course_modules
    @Mapping(source = "modules.cron", target = "cron")        // cron từ bảng modules
    @Mapping(source = "modules.lastcron", target = "lastcron")// lastcron từ bảng modules
    @Mapping(source = "modules.search", target = "search")
    CourseModuleDomain toDomain(CourseModules courseModules);

    @Mapping(source = "type", target = "moduleType")
    ModuleResponseDTO toModuleDTO(CourseModuleDomain domain);
}

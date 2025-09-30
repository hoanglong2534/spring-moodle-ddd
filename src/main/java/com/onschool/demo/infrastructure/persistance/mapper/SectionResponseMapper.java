package com.onschool.demo.infrastructure.persistance.mapper;

import com.onschool.demo.application.dto.response.SectionResponseDTO;
import com.onschool.demo.domain.model.SectionDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = ModuleMapper.class)
public interface SectionResponseMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "summary", target = "summary")
    @Mapping(source = "modules", target = "modules")
    SectionResponseDTO toResponse(SectionDomain section);

    List<SectionResponseDTO> toResponseList(List<SectionDomain> sections);
}
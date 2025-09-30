package com.onschool.demo.infrastructure.persistance.mapper;

import com.onschool.demo.application.dto.response.UrlResponseDTO;
import com.onschool.demo.infrastructure.persistance.entity.Url;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UrlMapper {

    UrlResponseDTO toDTO(Url url);

    Url toEntity(UrlResponseDTO urlResponseDTO);
}

package com.onschool.demo.infrastructure.persistance.mapper;

import com.onschool.demo.application.dto.response.QuestionResponseDTO;
import com.onschool.demo.infrastructure.persistance.entity.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionResponseDTO toDTO(Question question);

    Question toEntity(QuestionResponseDTO questionResponseDTO);
}

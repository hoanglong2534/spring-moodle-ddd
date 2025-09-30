package com.onschool.demo.infrastructure.persistance.mapper;

import com.onschool.demo.application.dto.response.QuizSlotResponseDTO;
import com.onschool.demo.infrastructure.persistance.entity.QuizSlots;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuizSlotMapper {
    QuizSlotResponseDTO toDTO(QuizSlots quizSlots);
}
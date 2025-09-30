package com.onschool.demo.infrastructure.persistance.mapper;

import com.onschool.demo.application.dto.response.QuestionAttemptsResponseDTO;
import com.onschool.demo.infrastructure.persistance.entity.QuestionAttempts;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuestionAttemptsMapper {


    @Mapping(source = "id", target = "id")
    @Mapping(source = "questionusageid", target = "questionusageid")
    @Mapping(source = "slot", target = "slot")
    @Mapping(source = "behaviour", target = "behaviour")
    @Mapping(source = "maxmark", target = "maxmark")
    @Mapping(source = "questionsummary", target = "questionsummary")
    @Mapping(source = "rightanswer", target = "rightanswer")
    @Mapping(source = "responsesummary", target = "responsesummary")
    @Mapping(source = "timemodified", target = "timemodified")
    QuestionAttemptsResponseDTO toDTO(QuestionAttempts questionAttempts);

    QuestionAttempts toEntity(QuestionAttemptsResponseDTO questionAttemptsResponseDTO);
}

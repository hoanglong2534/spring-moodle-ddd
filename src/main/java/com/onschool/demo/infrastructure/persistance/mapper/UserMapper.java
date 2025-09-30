package com.onschool.demo.infrastructure.persistance.mapper;

import com.onschool.demo.application.dto.response.UserResponseDTO;
import com.onschool.demo.infrastructure.persistance.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "firstname", target = "firstname")
    @Mapping(source = "lastname", target = "lastname")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "city", target = "city")
    @Mapping(source = "country", target = "country")
    UserResponseDTO toDTO(User user);
}

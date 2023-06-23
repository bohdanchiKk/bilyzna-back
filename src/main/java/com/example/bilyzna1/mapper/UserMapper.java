package com.example.bilyzna1.mapper;

import com.example.bilyzna1.dto.SignUpDto;
import com.example.bilyzna1.dto.UserDto;
import com.example.bilyzna1.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);
    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto userDto);
}

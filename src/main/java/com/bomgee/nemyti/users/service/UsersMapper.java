package com.bomgee.nemyti.users.service;

import com.bomgee.nemyti.users.model.User;
import com.bomgee.nemyti.users.model.UserDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UsersMapper {

    @Mappings({
            @Mapping(target = "password", ignore = true)
    })
    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);
}

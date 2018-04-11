package com.netcracker.unc.dto.mappers;

import com.netcracker.unc.dto.UserDto;
import com.netcracker.unc.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);
}

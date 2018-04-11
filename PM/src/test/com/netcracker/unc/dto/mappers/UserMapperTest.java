package com.netcracker.unc.dto.mappers;

import com.netcracker.unc.dto.UserDto;
import com.netcracker.unc.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

public class UserMapperTest {

    private UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Test
    public void userTouserDto() {
        User user = new User(1, "firstName", "lastName", "username", "password");
        UserDto userDto = mapper.userToUserDto(user);
        Assert.assertEquals(user.getUserId(), userDto.getUserId());
        Assert.assertEquals(user.getFirstName(), userDto.getFirstName());
        Assert.assertEquals(user.getLastName(), userDto.getLastName());
        Assert.assertEquals(user.getUsername(), userDto.getUsername());
        Assert.assertEquals(user.getPassword(), userDto.getPassword());
    }

    @Test
    public void userDtoTouser() {
        UserDto userDto = new UserDto(1, "firstName", "lastName", "username", "12345");
        User user = mapper.userDtoToUser(userDto);
        Assert.assertEquals(user.getUserId(), userDto.getUserId());
        Assert.assertEquals(user.getFirstName(), userDto.getFirstName());
        Assert.assertEquals(user.getLastName(), userDto.getLastName());
        Assert.assertEquals(user.getUsername(), userDto.getUsername());
        Assert.assertEquals(user.getPassword(), userDto.getPassword());
    }
}

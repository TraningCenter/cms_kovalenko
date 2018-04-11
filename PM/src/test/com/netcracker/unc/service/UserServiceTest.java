package com.netcracker.unc.service;

import com.netcracker.unc.dto.UserDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/applicationContext.xml"})
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void addUser() {
        UserDto user = new UserDto("Test2", "12345");
        userService.addUser(user);
        UserDto savedUser = userService.getUserByUsername("Test2");
        Assert.assertNotNull(savedUser);
        Assert.assertEquals(savedUser.getUsername(), user.getUsername());
        Assert.assertEquals(savedUser.getPassword(), user.getPassword());
        try {
            userService.addUser(user);
            Assert.fail();
        } catch (Exception ignored) {
        }
        userService.deleteUser(savedUser.getUserId());
    }

    @Test
    public void updateUser() {
        UserDto user = new UserDto("Test2", "12345");
        userService.addUser(user);
        UserDto savedUser = userService.getUserByUsername("Test2");
        Assert.assertNull(savedUser.getFirstName());
        savedUser.setFirstName("FirstName");
        userService.updateUser(savedUser);
        savedUser = userService.getUserById(savedUser.getUserId());
        Assert.assertEquals(savedUser.getFirstName(), "FirstName");
        userService.deleteUser(savedUser.getUserId());
    }
}

package com.netcracker.unc;

import com.netcracker.unc.model.User;
import com.netcracker.unc.service.UserService;
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
        User user = new User("Test2", "12345");
        userService.addUser(user);
        User savedUser = userService.getUserByUsername("Test2");
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
}

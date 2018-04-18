package com.netcracker.unc.controller;

import com.netcracker.unc.controller.exception.BadRequestException;
import com.netcracker.unc.controller.exception.DataNotFoundException;
import com.netcracker.unc.controller.exception.InternalServerErrorException;
import com.netcracker.unc.dto.PostDto;
import com.netcracker.unc.dto.UserDto;
import com.netcracker.unc.service.PostService;
import com.netcracker.unc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    PostService postService;

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public UserDto getUserById(@PathVariable("userId") Integer id) {
        if (id == null || id < 0) throw new BadRequestException();
        UserDto userDto;
        try {
            userDto = userService.getUserById(id);
        } catch (Exception e) {
            //TODO: LOG and throw
            throw new InternalServerErrorException();
        }
        return userDto;
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @ResponseBody
    public UserDto getUserByUsername(@PathVariable("username") String username) {
        if (username == null || username.isEmpty()) throw new BadRequestException();
        UserDto userDto = null;
        try {
            userDto = userService.getUserByUsername(username);
        } catch (Exception e) {
            //TODO: LOG and throw
            throw new InternalServerErrorException();
        }
        return userDto;
    }

    @RequestMapping(value = "/{userId}/posts", method = RequestMethod.GET)
    @ResponseBody
    public List<PostDto> getAllPostsByUserId(@PathVariable("userId") Integer id) {
        if (id == null || id < 0) throw new BadRequestException();
        return postService.getAllPostsByUserId(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserDto userDto) {
        if (userDto == null) throw new BadRequestException();
        userService.addUser(userDto);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public void updatePost(@PathVariable("userId") Integer id, @RequestBody UserDto userDto) {
        if (id == null || id < 0) throw new BadRequestException();
        if (userDto == null) throw new BadRequestException();
        userService.updateUser(userDto);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserDto login(@RequestBody UserDto userDto) {
        if (userDto == null) throw new BadRequestException();
        return userService.login(userDto);
    }
}

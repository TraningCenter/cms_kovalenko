package com.netcracker.unc.service;

import com.netcracker.unc.dao.UserDao;
import com.netcracker.unc.dto.UserDto;
import com.netcracker.unc.dto.mappers.UserMapper;
import com.netcracker.unc.model.User;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserDao dao;
    private UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Transactional
    public List<UserDto> getAll() {
        List<User> users = dao.getAllUsers();
        return users.stream()
                .map(elem -> mapper.userToUserDto(elem))
                .collect(Collectors.toList());
    }

    @Transactional
    public UserDto getUserById(Integer id) {
        User user = dao.getUserById(id);
        return mapper.userToUserDto(user);
    }

    @Transactional
    public UserDto getUserByUsername(String username) {
        User user = dao.getUserByUsername(username);
        return mapper.userToUserDto(user);
    }

    @Transactional
    public void addUser(UserDto userDto) {
        User user = mapper.userDtoToUser(userDto);
        dao.addUser(user);
    }

    @Transactional
    public void updateUser(UserDto userDto) {
        User user = mapper.userDtoToUser(userDto);
        dao.updateUser(user);
    }

    @Transactional
    public void deleteUser(Integer id) {
        dao.deleteUser(id);
    }
}

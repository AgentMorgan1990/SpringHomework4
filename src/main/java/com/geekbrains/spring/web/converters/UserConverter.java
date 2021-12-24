package com.geekbrains.spring.web.converters;

import org.springframework.stereotype.Component;
import com.geekbrains.spring.web.dto.UserDto;
import com.geekbrains.spring.web.entities.User;

@Component
public class UserConverter {
    public User dtoToEntity(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        return user;
    }

    public UserDto entityToDto(User user) {
        return new UserDto(user.getUsername(), user.getPassword(),user.getEmail());
    }
}

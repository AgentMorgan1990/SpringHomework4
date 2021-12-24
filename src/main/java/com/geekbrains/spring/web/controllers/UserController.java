package com.geekbrains.spring.web.controllers;

import org.springframework.web.bind.annotation.*;

import com.geekbrains.spring.web.converters.UserConverter;
import com.geekbrains.spring.web.dto.UserDto;
import com.geekbrains.spring.web.entities.User;
import com.geekbrains.spring.web.services.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserConverter userConverter;
    private final UserService userService;

    @PostMapping
    public UserDto createNewUser(@RequestBody UserDto userDto) {
        User user = userConverter.dtoToEntity(userDto);
        userService.save(user);
        return userConverter.entityToDto(userService.findByUsername(user.getUsername()).get());
    }
}

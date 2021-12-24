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
    public void createNewUser(@RequestBody UserDto userDto) {
        User user = userConverter.dtoToEntity(userDto);
        userService.save(user);
        User user1 = userService.findByUsername(user.getUsername()).get();
        System.out.println(user1.getId());
        System.out.println(user1.getUsername());
        System.out.println(user1.getPassword());
        System.out.println(user1.getEmail());
    }
}

package com.noice.xxxx.users.app.resources.users.v1.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.noice.xxxx.users.app.resources.users.v1.dto.UserDto;

@RestController
public class UsersController {
	public static final String NAME = "/users";
	
	@RequestMapping(value=NAME, method=RequestMethod.GET)
    public List<UserDto> listeProduits() {
        return Arrays.asList(UserDto.builder().username("Kamule").build());
    }
}

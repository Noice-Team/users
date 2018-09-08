package com.noice.xxxx.users.app.resources.users;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
	public static final String NAME = "/users";
	
	@RequestMapping(value=NAME, method=RequestMethod.GET)
    public String listeProduits() {
        return "Un exemple d'utilisateur";
    }
}

package com.noice.xxxx.users.app.resources.users.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.noice.xxxx.users.app.db.user.UserDao;
import com.noice.xxxx.users.app.execeptions.DatabaseException;
import com.noice.xxxx.users.app.execeptions.UserNotFoundException;
import com.noice.xxxx.users.app.resources.users.v1.dto.UserDto;

@RestController
public class UsersController {
	public static final String NAME = "/users";

	@Autowired
	private UserDao dao;

	@RequestMapping(value = NAME, method = RequestMethod.GET)
	public List<UserDto> listUsers() throws DatabaseException {
		return this.dao.getUsers();
	}

	@RequestMapping(value = NAME + "/{id}", method = RequestMethod.GET)
	public UserDto getUser(@PathVariable("id") String id) throws UserNotFoundException, DatabaseException {
		return this.dao.getUser(id);
	}

//	@RequestMapping(value = "/error")
//	@ResponseBody
//	public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
//		Map<String, Object> body = new HashMap<>();
//		body.put("error", request);
////		HttpStatus status = getStatus(request);
//		return new ResponseEntity<Map<String, Object>>(body, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
}

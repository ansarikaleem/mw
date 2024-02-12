package com.aub.kfh.mw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aub.kfh.mw.bean.User;
import com.aub.kfh.mw.secured.JwtGenerator;
import com.aub.kfh.mw.secured.UserNotFoundException;
import com.aub.kfh.mw.service.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController implements UserApi{

	@Autowired
	private UserService userService;

	@Autowired
	private JwtGenerator jwtGenerator;


	@PostMapping("/register")
	public ResponseEntity<?> postUser(@RequestBody User user) {
		try {
			userService.saveUser(user);
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) {
		try {
			if (user.getUserName() == null || user.getPassword() == null) {
				throw new UserNotFoundException("UserName or Password is Empty");
			}
			User userData = userService.getUserByNameAndPassword(user.getUserName(), user.getPassword());
			if (userData == null) {
				throw new UserNotFoundException("UserName or Password is Invalid");
			}
			return new ResponseEntity<>(jwtGenerator.generateToken(user), HttpStatus.OK);
		} catch (UserNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
}
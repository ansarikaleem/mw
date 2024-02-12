package com.aub.kfh.mw.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.aub.kfh.mw.bean.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User API", description = "All User related API")
public interface UserApi {
	
	@Operation(summary = "Post User", description = "Post User Body")
	public ResponseEntity<?> postUser(@RequestBody User user);
	
	@Operation(summary = "Login API", description = "Login User ")
	public ResponseEntity<?> loginUser(@RequestBody User user);

}

package com.aub.kfh.mw.service;

import org.springframework.stereotype.Service;

import com.aub.kfh.mw.bean.User;
import com.aub.kfh.mw.secured.UserNotFoundException;

@Service
public interface UserService {
	
	public void saveUser(User user);

	public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException;
}

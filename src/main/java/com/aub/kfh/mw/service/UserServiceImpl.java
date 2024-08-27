package com.aub.kfh.mw.service;

import org.springframework.stereotype.Service;

import com.aub.kfh.mw.bean.User;
import com.aub.kfh.mw.secured.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public void saveUser(User user) {

		System.out.println("save into DB.");
	}

	@Override
	public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException {
		User user = new User();
		user.setUserName(name);
		user.setPassword(password);
		return user;
	}
}

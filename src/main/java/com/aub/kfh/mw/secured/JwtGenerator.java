package com.aub.kfh.mw.secured;

import org.springframework.stereotype.Service;

import com.aub.kfh.mw.bean.User;

@Service
public interface JwtGenerator {

	String generateToken(User user);

}

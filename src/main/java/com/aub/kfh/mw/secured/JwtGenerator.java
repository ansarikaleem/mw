package com.aub.kfh.mw.secured;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.aub.kfh.mw.bean.User;

@Service
public interface JwtGenerator {

	Map<String, String> generateToken(User user);

}

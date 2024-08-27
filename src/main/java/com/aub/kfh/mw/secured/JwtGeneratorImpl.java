package com.aub.kfh.mw.secured;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aub.kfh.mw.bean.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtGeneratorImpl implements JwtGenerator {

	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${app.jwttoken.message}")
	private String message;
	
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;


	@Override
	public String generateToken(User user) {
		
		String jwtToken = doGenerateToken("mw");
		System.out.println("Generated Token is : "+jwtToken);
		
		return jwtToken;
	}
	
	private String doGenerateToken(String subject) {
		

		return Jwts.builder()
				.setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}

}
